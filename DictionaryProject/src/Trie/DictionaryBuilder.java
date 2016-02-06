package Trie;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;

public class DictionaryBuilder {

	private JFrame frame;
	private JTextField txtEnterAWord;
	private JTextArea textArea;
	private JButton btnAddWord;
	private JButton btnUpdateWord;
	private JButton btnRemoveWord;
	private JDialog d;
	private JDialog d1;
	private JDialog d2;
	private JDialog d3;
	public Trie t;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNew;
	private JTextField txtDescription;
	private String wordAdd;
	private String descriptionAdd;

	private final JPanel contentPanel1 = new JPanel();
	private JTextField txtNew1;
	private JTextArea txtDescription1;
	private String wordUpdate;
	private String descriptionUpdate;

	private final JPanel contentPanel2 = new JPanel();
	private JButton btnNewButton;
	private final JPanel contentPanel3 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					DictionaryBuilder window = new DictionaryBuilder();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DictionaryBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		t = new Trie();
		t.read("words.txt");
		frame = new JFrame();
		frame.setTitle("Dictionary");
		frame.setBounds(100, 100, 507, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton searchButton = new JButton("search");
		searchButton.setBounds(396, 11, 85, 28);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String word = txtEnterAWord.getText();
				String description = t.search(word);
				textArea.setText(t.searchToString(description));
				// textField.setText(t.search(word));

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(searchButton);

		txtEnterAWord = new JTextField();
		txtEnterAWord.setBounds(10, 11, 366, 23);
		txtEnterAWord.setText("Enter a word here.");
		frame.getContentPane().add(txtEnterAWord);
		txtEnterAWord.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(10, 46, 366, 193);
		frame.getContentPane().add(textArea);

		d = new JDialog();
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d.setVisible(false);
		d.setBounds(100, 100, 450, 300);
		d.getContentPane().setLayout(new BorderLayout());

		btnAddWord = new JButton("Add word");
		btnAddWord.setBounds(10, 260, 105, 23);
		btnAddWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d.setVisible(true);
				showAddDialog();

			}
		});
		frame.getContentPane().add(btnAddWord);

		d1 = new JDialog();
		d1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d1.setVisible(false);
		d1.setBounds(100, 100, 450, 300);
		d1.getContentPane().setLayout(new BorderLayout());

		btnUpdateWord = new JButton("Update word");
		btnUpdateWord.setBounds(125, 260, 129, 23);
		btnUpdateWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d1.setVisible(true);
				showUpdateDialog();
				txtDescription1.setText("");

			}
		});
		frame.getContentPane().add(btnUpdateWord);

		d2 = new JDialog();
		d2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d2.setVisible(false);
		d2.setBounds(100, 100, 450, 300);
		d2.getContentPane().setLayout(new BorderLayout());

		btnRemoveWord = new JButton("Remove");
		btnRemoveWord.setBounds(266, 260, 110, 23);
		btnRemoveWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d2.setVisible(true);
				showRemove();
			}
		});
		frame.getContentPane().add(btnRemoveWord);

		d3 = new JDialog();
		d3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d3.setVisible(false);
		d3.setBounds(100, 100, 450, 300);
		d3.getContentPane().setLayout(new BorderLayout());

		btnNewButton = new JButton("All");
		btnNewButton.setBounds(396, 49, 85, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d3.setVisible(true);
				All();
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(398, 260, 83, 33);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.save();
			}
		});
		frame.getContentPane().add(btnSave);
	}

	public void showAddDialog() {

		d.setBounds(100, 100, 450, 300);
		d.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		d.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNew = new JTextField();
			txtNew.setBounds(90, 38, 252, 25);
			contentPanel.add(txtNew);
			txtNew.setColumns(10);
		}
		{
			txtDescription = new JTextField();
			txtDescription.setHorizontalAlignment(SwingConstants.LEFT);
			txtDescription.setBounds(90, 89, 252, 106);
			contentPanel.add(txtDescription);
			txtDescription.setColumns(10);
		}

		JLabel lblAddNewWord = new JLabel("New word ");
		lblAddNewWord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddNewWord.setBounds(90, 22, 85, 16);
		contentPanel.add(lblAddNewWord);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescription.setBounds(90, 74, 85, 14);
		contentPanel.add(lblDescription);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			d.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(396, 11, 85, 28);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						wordAdd = txtNew.getText();
						descriptionAdd = txtDescription.getText();

						t.add(wordAdd, descriptionAdd);
						txtNew.setText("");
						txtDescription.setText("");
						d.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				d.getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(396, 11, 85, 28);

				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						d.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}

	public void showUpdateDialog() {

		d1.setBounds(100, 100, 450, 300);
		d1.getContentPane().setLayout(new BorderLayout());
		contentPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		d1.getContentPane().add(contentPanel1, BorderLayout.CENTER);
		contentPanel1.setLayout(null);
		{
			txtNew1 = new JTextField();
			txtNew1.setBounds(90, 38, 252, 25);
			contentPanel1.add(txtNew1);
			txtNew1.setColumns(10);
		}
		{
			txtDescription1 = new JTextArea();
			txtDescription1.setBounds(40, 93, 371, 106);
			contentPanel1.add(txtDescription1);
			txtDescription1.setColumns(10);
		}

		JLabel lblAddNewWord1 = new JLabel("Word ");
		lblAddNewWord1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddNewWord1.setBounds(90, 22, 85, 16);
		contentPanel1.add(lblAddNewWord1);

		JLabel lblDescription1 = new JLabel("New Description");
		lblDescription1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescription1.setBounds(90, 74, 105, 24);
		contentPanel1.add(lblDescription1);
		{
			JButton btnSearch1 = new JButton("Search");
			btnSearch1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String w = txtNew1.getText();
					String des = t.search(w);
					txtDescription1.setText(t.searchToString(des));
				}
			});
			btnSearch1.setBounds(345, 39, 89, 23);
			contentPanel1.add(btnSearch1);
		}
		{
			JPanel buttonPane1 = new JPanel();
			buttonPane1.setLayout(new FlowLayout(FlowLayout.RIGHT));
			d1.getContentPane().add(buttonPane1, BorderLayout.SOUTH);
			{
				JButton okButton1 = new JButton("OK");
				okButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						wordUpdate = txtNew1.getText();
						descriptionUpdate = txtDescription1.getText();

						t.update(wordUpdate, descriptionUpdate);
						txtNew1.setText("");
						txtDescription1.setText("");
						d1.setVisible(false);
					}
				});
				okButton1.setActionCommand("OK");
				buttonPane1.add(okButton1);
				d1.getRootPane().setDefaultButton(okButton1);
			}
			{
				JButton cancelButton1 = new JButton("Cancel");
				cancelButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						d1.setVisible(false);
					}
				});
				cancelButton1.setActionCommand("Cancel");
				buttonPane1.add(cancelButton1);
			}
		}

	}

	public void showRemove() {

		d2.setBounds(100, 100, 450, 300);
		d2.getContentPane().setLayout(new BorderLayout());
		contentPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		d2.getContentPane().add(contentPanel2, BorderLayout.CENTER);
		contentPanel2.setLayout(null);
		{
			JButton btnOk2 = new JButton("OK");
			btnOk2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String removeWord = txtEnterAWord.getText();
					//remove word from trie
					t.remove(removeWord);
					txtEnterAWord.setText("Enter a word here.");

					d2.setVisible(false);
				}
			});
			btnOk2.setBounds(100, 132, 109, 50);
			contentPanel2.add(btnOk2);
		}
		{
			JButton btnCancel2 = new JButton("Cancel");
			btnCancel2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					d2.setVisible(false);
				}
			});
			btnCancel2.setBounds(219, 132, 109, 50);
			contentPanel2.add(btnCancel2);
		}
		{
			JLabel lblDoYouReally = new JLabel(
					"Do you really want to remove this word?");
			lblDoYouReally.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDoYouReally.setBounds(100, 37, 259, 42);
			contentPanel2.add(lblDoYouReally);
		}
		{
			JTextArea textArea2 = new JTextArea();
			textArea2.setBounds(128, 90, 152, 16);
			contentPanel2.add(textArea2);
			textArea2.setText(txtEnterAWord.getText());
		}
		{
			JPanel buttonPane2 = new JPanel();
			buttonPane2.setLayout(new FlowLayout(FlowLayout.RIGHT));
			d2.getContentPane().add(buttonPane2, BorderLayout.SOUTH);
		}

	}

	public void All() {

		d3.setBounds(100, 100, 450, 300);
		d3.getContentPane().setLayout(new BorderLayout());
		contentPanel3.setBorder(new EmptyBorder(5, 5, 5, 5));
		d3.getContentPane().add(contentPanel3, BorderLayout.CENTER);
		contentPanel3.setLayout(null);
		{
			JButton btnCancel4 = new JButton("Back");
			btnCancel4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					d3.setVisible(false);
				}
			});
			btnCancel4.setBounds(359, 217, 65, 23);
			contentPanel3.add(btnCancel4);
		}
		{
			JLabel lblDoYouReally4 = new JLabel("All words");
			lblDoYouReally4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDoYouReally4.setBounds(10, 0, 251, 30);
			contentPanel3.add(lblDoYouReally4);
		}

		TextArea textArea4 = new TextArea();
		textArea4.setText(t.showAll().toString());
		textArea4.setBounds(10, 25, 414, 186);
		contentPanel3.add(textArea4);
		{
			JPanel buttonPane4 = new JPanel();
			buttonPane4.setLayout(new FlowLayout(FlowLayout.RIGHT));
			d3.getContentPane().add(buttonPane4, BorderLayout.SOUTH);
		}

	}
}