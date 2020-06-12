import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.opencsv.CSVReader;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class User extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		setTitle("BlueRoll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//create button
		final JButton btnRollCall = new JButton("START ROLL CALL");
		btnRollCall.setBackground(SystemColor.activeCaption);
		btnRollCall.setForeground(SystemColor.windowText);
		btnRollCall.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
		btnRollCall.setBounds(182, 291, 300, 50);
		contentPane.add(btnRollCall);

		//create logo
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(UserInterface.class.getResource("/images/BlueRollLogo.jpg")));
		label_1.setBounds(210, 130, 564, 133);
		contentPane.add(label_1);

		JButton btnViewSemesterReport = new JButton("VIEW SEMESTER REPORT");
		btnViewSemesterReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewSemesterReport();	
			}
		});

		btnViewSemesterReport.setForeground(SystemColor.windowText);
		btnViewSemesterReport.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
		btnViewSemesterReport.setBackground(SystemColor.activeCaption);
		btnViewSemesterReport.setBounds(494, 291, 300, 50);
		contentPane.add(btnViewSemesterReport);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 982, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Select Class :-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 37, 137, 35);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "CSE 2A", "CSE3A", "Btech"}));
		comboBox.setBounds(149, 43, 112, 22);
		panel.add(comboBox);

	
		btnRollCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewSummaryReport();
			}



		});
	}

	private void viewSemesterReport(){

		JFrame semesterReportFrame = new JFrame();

		semesterReportFrame.getContentPane().setBackground(SystemColor.window);
		semesterReportFrame.setBounds(100, 100, 1000, 500);
		semesterReportFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		semesterReportFrame.getContentPane().setLayout(null);
		semesterReportFrame.setTitle("BlueRoll | Semester Report");
		semesterReportFrame.setLocationRelativeTo(null);
		semesterReportFrame.setVisible(true);

		JLabel lblNewLabel = new JLabel("SEMESTER REPORT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(308, 32, 367, 71);
		semesterReportFrame.getContentPane().add(lblNewLabel);


		Object[][] rowData = {};
		Object[] columnNames = {};
		DefaultTableModel resultsTableModel = new DefaultTableModel(rowData, columnNames);
		JTable resultsTable = new JTable(resultsTableModel);
		resultsTable.setModel(resultsTableModel);
		resultsTable.setBounds(59, 208, 210, -149);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 964, 316);
		semesterReportFrame.getContentPane().add(scrollPane);

		try {
			CSVReader r = new CSVReader(new FileReader("semesterReport.csv"));
			List<String[]> allLines = r.readAll();
			
			int length = (allLines.get(0).length);
			int k= 0;
			while (length > k){
			for(String line : allLines.get(0)){
					resultsTableModel.addColumn(line);
					k++;
				}
			}
			allLines.remove(0);
			for(String[] line : allLines){
					resultsTableModel.addRow(line);
			}
			r.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(resultsTable);

	}

	private void viewSummaryReport(){

		Main.locateDevices();
		Main.setAttend();

		JFrame summaryReportFrame = new JFrame();

		summaryReportFrame.getContentPane().setBackground(SystemColor.window);
		summaryReportFrame.getContentPane().setLayout(null);
		summaryReportFrame.setBounds(100, 100, 1000, 500);
		summaryReportFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		summaryReportFrame.getContentPane().setLayout(null);
		summaryReportFrame.setTitle("BlueRoll | Summary Report");
		summaryReportFrame.setLocationRelativeTo(null);
		summaryReportFrame.setVisible(true);



		JLabel lblNewLabel = new JLabel("SUMMARY REPORT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(308, 32, 367, 71);
		summaryReportFrame.getContentPane().add(lblNewLabel);

		TextArea textArea = new TextArea();
		textArea.setText("");
		textArea.setForeground(SystemColor.textInactiveText);
		textArea.setBackground(SystemColor.window);
		textArea.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		textArea.setBounds(28, 130, 933, 307);
		textArea.setEditable(false);

		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = Main.getStudents();
		StringBuilder summaryReport = new StringBuilder();
		summaryReport.delete(0, summaryReport.length());
		
		int count = 0;
		for(Student st : studentList){
			if(st.isPresent()){
				summaryReport.append(st.getStudentName() +  " is present,  " + "\n");

				count++;
			}else{
				summaryReport.append(st.getStudentName() + " is absent,  " + "\n");
			}
		}

		double percent = (count*1.0/studentList.size())*100;
		String percentString = "That is " +percent+ "% of the class!";
		summaryReport.append(percentString);
		String results = summaryReport.toString();
		textArea.setText(results);
		summaryReportFrame.getContentPane().add(textArea);

	}


	public JPanel getFrame() {
		return contentPane;
	}


	public void setFrame(JPanel frame) {
		this.contentPane = frame;
	}
	}

	
		
	
	


