package swingdictionary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingDictionary extends JFrame{

	Set<String> sameWord = new HashSet<>();
	JTextArea area;
	JComboBox<String> cb;
	DictionaryData dd = new DictionaryData();
	JButton jb = new JButton("검색");
	JTextField t1 = new JTextField(10);


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
		JPanel p3 = new JPanel();
		JPanel panel = new JPanel(new GridLayout( 3 , 0 ));
		cb = new JComboBox<String>();
		cb.setPreferredSize(new Dimension(100,20));
		
		t1.addActionListener(e -> {
		    String text = t1.getText();

		    if (!text.isEmpty() && sameWord.add(text) && inDictionarydata(text)) {
		        cb.addItem(text);
		        t1.setText("");
		        loadData(text);
		    } else {
		        JOptionPane.showMessageDialog(null, "검색할수 없는 단어입니다.");
		    }
		});
		
		jb.addActionListener( e -> {
                String text = t1.getText();

                if (!text.isEmpty()&&sameWord.add(text) && inDictionarydata(text)) {
                    cb.addItem(text);
                    t1.setText("");
                    loadData(text);
                }else {
                	JOptionPane.showMessageDialog(null,"검색할수 없는 단어입니다." );
                }
		});
		cb.addActionListener(e ->{
                String selectedWord = (String) cb.getSelectedItem();
                
                loadData(selectedWord);
        });
		p1.add( new JLabel("검색할 단어를 입력하세요"));
		p2.add(t1);
		p2.add(jb);
		p3.add( new JLabel(" 검색 리스트"));
		
		p3.add(cb);
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
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
	void loadData(String selectedWord) {
	    StringBuilder sb = new StringBuilder();
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
	    area.setText(sb.toString());

	}
	
	private boolean inDictionarydata(String word) {
		for(String[] entry : dd.loadData()) {
			if(entry != null && entry.length > 0 && entry[0] != null) {
				if(entry[0].equals(word)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new SwingDictionary();

	}


}
