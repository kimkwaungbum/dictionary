package swingdictionary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingDictionary extends JFrame{

	Set<String> sameWord = new HashSet<>();
	JTextArea area;
	JComboBox<String> cb;
	DictionaryData dd = new DictionaryData();


	SwingDictionary(){
		setTitle("사전만들기");
		setSize(600, 700);
		setLayout(new BorderLayout(10,10));
		showNorth();
		showCenter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new GridLayout( 2 , 0 ));


		cb = new JComboBox<>();

		JButton jb = new JButton("검색");
		JTextField t1 = new JTextField(10);

		jb.addActionListener( e -> {
                String text = t1.getText();

                if (!text.isEmpty()&&sameWord.add(text)) {
                    cb.addItem(text);
                    t1.setText("");

                }
                loadData();

		});

		p1.add(jb);
		p2.add( new JLabel("리스트"));
		p1.add(t1);
		p2.add(cb);
		panel.add(p1);
		panel.add(p2);

		add(panel,BorderLayout.NORTH);


	}
	void showCenter() {
		JPanel p= new JPanel();
		area = new JTextArea( 30 , 20 );
		area.setText("");
		area.setEditable(false);
		p.add(area);
		add(p,BorderLayout.CENTER);
	}
	void loadData() {
	    StringBuilder sb = new StringBuilder();
	    String selectedWord = (String) cb.getSelectedItem();
	    boolean wordFound = false;



	    for (String[] entry : dd.loadData()) {
	        if (entry != null && entry.length > 0 && entry[0] != null) {
	            if (entry[0].equals(selectedWord)) {
	                wordFound = true;
	                for (String info : entry) {
	                    sb.append(info).append("\n");
	                }
	                sb.append("\n");
	            }
	        }
	    }

	    if (!wordFound) {
	        sb.append("찾을 수 없는 데이터입니다.");
	    }

	        area.setText(sb.toString());

	}

	public static void main(String[] args) {
		new SwingDictionary();

	}


}
