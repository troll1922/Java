package fomichev.convertHtml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * Класс создания рабочего окна программы
 * @author Aleksey Fomichev
 */
public class ProgramWindow extends JFrame {
	private JFileChooser fileText = null;		//Ссылка на файл с текстом
	private JFileChooser fileDictionary = null;	//Ссылка на словарь
	private FileNameExtensionFilter filter;		//Фильтр 
	private SpinnerModel sm;					//Задаем значения в спинбоксе
	private JSpinner spinner;					//Поле в кот. задается кол-во строк в HTML файле
	private int countString;					//Счетчик строк
	private Boolean chooseFileText = false;		//Выбран файл текста или нет
	private Boolean chooseFileDictionary = false;	//Выбран словарь или нет
	private final int LENGTH_FILE = 2097152;	//Длина файла 2 Мb
	
	/**
	 * Конструктор
	 */
	public ProgramWindow () {        
		super ("Convert to HTML"); //Вызываем конструктор родителя
		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		sm = new SpinnerNumberModel(10, 10, 100000, 1);
		spinner = new JSpinner(sm);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);	//Задаем размеры окна
		final DetailsWindow details = new DetailsWindow(); //Создаем объект класса детали окна
		getContentPane().add(details.getPanel());
		final LoadDictionary dict = new LoadDictionary();  //Создаем объект загрузки словаря
		//Слушатели
		details.btn1.addActionListener(new ActionListener() {
			//выбираем файл с текстом
            public void actionPerformed(ActionEvent e) {
            	fileText = new JFileChooser(); 
            	fileText.setFileFilter(filter);
                int ret = fileText.showDialog(null, "Открыть файл с текстом");               
                if (ret == JFileChooser.APPROVE_OPTION) {
                	chooseFileText = true;                	
                    File file1 = fileText.getSelectedFile();
                    int dotPos = file1.getName().lastIndexOf(".");
                	String ext = file1.getName().substring(dotPos); //узнаем расширение файла
                    long lenFileText = file1.length();  //определяем размер файла
                    if (lenFileText > LENGTH_FILE) {
                    	JOptionPane.showMessageDialog(null,"Размер файла не должен превышать 2Mb", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    	details.lbl1.setText("Файл не выбран");
                        chooseFileText = false;
                    }
                    else if (!(ext.equals(".txt"))) {
                    	JOptionPane.showMessageDialog(null,"Расширение файла не .txt", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    	details.lbl1.setText("Файл не выбран");
                        chooseFileText = false;
                    }
                    else details.lbl1.setText(file1.getName());
                }
            }
        });
		
		details.btn2.addActionListener(new ActionListener() {
			//выбираем файл словарь
            public void actionPerformed(ActionEvent e) {
            	fileDictionary = new JFileChooser();   
            	fileDictionary.setFileFilter(filter);
                int ret = fileDictionary.showDialog(null, "Открыть файл с текстом");               
                if (ret == JFileChooser.APPROVE_OPTION) {
                	chooseFileDictionary = true;
                    File file2 = fileDictionary.getSelectedFile();
                    int dotPos = file2.getName().lastIndexOf(".");
                	String ext = file2.getName().substring(dotPos); //узнаем расширение файла
                	long lenFileDictionary = file2.length();  		//определяем размер файла
                	if (lenFileDictionary > LENGTH_FILE) {
                    	JOptionPane.showMessageDialog(null,"Размер файла не должен превышать 2Mb", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    	details.lbl2.setText("Файл не выбран");
                        chooseFileDictionary = false;
                	}
                        else if (!(ext.equals(".txt"))) {   
	                    	JOptionPane.showMessageDialog(null,"Расширение файла не .txt", "Ошибка", JOptionPane.ERROR_MESSAGE);
	                    	details.lbl2.setText("Файл не выбран");
	                        chooseFileDictionary = false;
	                    }             	
	                    else if ((dict.sizeDictionary(file2))>100000) {   //вызываем метод по считыванию словаря
	                           	JOptionPane.showMessageDialog(null,"В словаре не д.б. > 100 000 строк", "Ошибка", JOptionPane.ERROR_MESSAGE);
	                           	details.lbl2.setText("Файл не выбран");
		                    	chooseFileDictionary = false;
	                        }
	                else details.lbl2.setText(file2.getName());
                }
            }
        });

		details.btn3.addActionListener(new ActionListener() {   
			//создание объекта HTML
            public void actionPerformed(ActionEvent e) {	
            	countString = (Integer)spinner.getValue();  		//считываем значение заданных строк
            	if (chooseFileText&&chooseFileDictionary) {
            		new HTML(fileText, dict.dectionaryList, countString);     //создаем объект HTML
            		JOptionPane.showMessageDialog(null,"Файл HTML сгенерирован успешно", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else JOptionPane.showMessageDialog(null,"Выбраны не все файлы", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
	}
	
	public class DetailsWindow {
		/**
		 * Иннер класс по созданию деталей окна
		 */
		private JButton btn1;
		public JLabel lbl1;
		private JButton btn2;
		public JLabel lbl2;
		private JButton btn3;
		public JLabel lbl3;
		private JPanel pnl;
		public DetailsWindow () {
			btn1 = new JButton ("Выбрать файл с текстом");
			lbl1 = new JLabel ("Файл не выбран");
			btn2 = new JButton ("Выбрать файл словаря");
			lbl2 = new JLabel ("Файл не выбран");
			btn3 = new JButton ("Создать HTML_файл");
			lbl3 = new JLabel("Укажите кол-во строк в файле HTML от 10 до 100 000");
			pnl = new JPanel();
			pnl.setLayout(null);
			//Так как объектов не много, расставим статически
			btn1.setSize(220, 30); 
			btn1.setLocation(85, 10);  
			lbl1.setSize(280, 20); 
			lbl1.setLocation(130, 50);
			btn2.setSize(220, 30); 
			btn2.setLocation(85, 80);
			lbl2.setSize(280, 20); 
			lbl2.setLocation(130, 120);
			btn3.setSize(220, 30); 
			btn3.setLocation(85, 150);
			lbl3.setSize(390, 20); 
			lbl3.setLocation(10, 190);
			spinner.setSize(70, 25); 
			spinner.setLocation(150, 220);
			pnl.add(btn1); 
			pnl.add(lbl1);
			pnl.add(btn2);
			pnl.add(lbl2);
			pnl.add(btn3);
			pnl.add(lbl3);
			pnl.add(spinner);
		}
		JPanel getPanel () {	//Возвращает панель с настроенными деталями окна
			return this.pnl; 
		}
	}
}