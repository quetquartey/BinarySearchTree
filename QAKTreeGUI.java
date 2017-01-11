import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.*;

public class QAKTreeGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblOrig;
	private JLabel lblSorted;
	private JButton btnSort;
	private JTextField txtOrig;
	private JTextField txtSorted;
	private JRadioButton rbAscending;
	private JRadioButton rbDescending;
	private JRadioButton rbInteger;
	private JRadioButton rbFraction;
	private ButtonGroup sortOrder;
	private ButtonGroup numType;
	private Box sortBox;
	private Box numTypeBox;
	private QAKBinarySearchTree tree;
	
	public QAKTreeGUI() throws NumberFormatExpressionException
	{			

		setPreferredSize(new Dimension(500,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());	
		GridBagConstraints framegbc = new GridBagConstraints();
		framegbc.gridx = 0;
		framegbc.gridy = 0;
		framegbc.weightx = 0.5;
		framegbc.gridheight = 1;
		framegbc.gridwidth = 1;
		framegbc.fill = GridBagConstraints.BOTH;
		framegbc.anchor = GridBagConstraints.FIRST_LINE_START;

		
		lblOrig = new JLabel("Original List", Label.LEFT);
		add(lblOrig,framegbc);
		framegbc.gridx = 1;
		txtOrig = new JTextField(25);
		add(txtOrig,framegbc);
		
		framegbc.gridx=0;
		framegbc.gridy=1;
		framegbc.insets = new Insets(30,0,0,0);
		lblSorted = new JLabel("Sorted List", Label.LEFT);
		add(lblSorted,framegbc);
		framegbc.gridx=1;
		
		txtSorted = new JTextField(25);
		txtSorted.setEditable(false);
		add(txtSorted,framegbc);
		framegbc.gridx=1;
		framegbc.gridy = 2;
		framegbc.fill = GridBagConstraints.VERTICAL;
		framegbc.anchor = GridBagConstraints.NORTH;
		btnSort = new JButton("Perform Sort");
		add(btnSort,framegbc);
		btnSort.addActionListener(this);
		
		rbAscending = new JRadioButton("Ascending           ");
		rbAscending.setSelected(true);
		rbDescending = new JRadioButton("Descending          ");
		sortOrder = new ButtonGroup();
		sortOrder.add(rbAscending);
		sortOrder.add(rbDescending);
		sortBox = Box.createVerticalBox();
		sortBox.setBorder(BorderFactory.createTitledBorder("Sort Order"));
		sortBox.add(rbAscending);
		sortBox.add(rbDescending);
		framegbc.gridx=0;
		framegbc.gridy=5;
		add(sortBox,framegbc);

		rbInteger = new JRadioButton("Integer             ");
		rbInteger.setSelected(true);
		rbFraction = new JRadioButton("Fraction            ");
		numType = new ButtonGroup();
		numType.add(rbInteger);
		numType.add(rbFraction);
		numTypeBox = Box.createVerticalBox();
		numTypeBox.setBorder(BorderFactory.createTitledBorder("Numeric Type"));
		numTypeBox.add(rbInteger);
		numTypeBox.add(rbFraction);
		framegbc.gridx = 1;
		framegbc.gridx=5;
		add(numTypeBox,framegbc);
		
		setTitle("Binary Search Tree Sort");		
		pack();
		setVisible(true);
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try
		{
			new QAKTreeGUI();
		}
		catch(NumberFormatExpressionException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		StringTokenizer strText = new StringTokenizer(txtOrig.getText());

		if ( rbInteger.isSelected() )
		{
			try
			{
				tree =  new QAKBinarySearchTree<Object>(Integer.parseInt(strText.nextToken()));
			}
			catch(NumberFormatException e2)
			{
				try {
					throw new NumberFormatExpressionException();
				} catch (NumberFormatExpressionException e3) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
			}
	
			while( strText.hasMoreTokens())
			{
				try
				{
					tree.addNode(new Node(Integer.parseInt(strText.nextToken())), tree.root, tree.root);			
				}
				catch(NumberFormatException e4)
				{
					try {
						throw new NumberFormatExpressionException();
					} catch (NumberFormatExpressionException e5) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e5.getMessage());
					}
				}
		 
			}

			if ( rbAscending.isSelected() )
			{	
				txtSorted.setText(tree.inOrderString(tree.root,""));
			}
			else
			{	
				txtSorted.setText(tree.revOrderString(tree.root,""));
			}				
		}
		else
		{
		
			try
			{
				tree =  new QAKBinarySearchTree<Object>(new Fraction(strText.nextToken()));				
			}
			catch(NumberFormatExpressionException e6)
			{
				JOptionPane.showMessageDialog(null, e6.getMessage());
				return;
			}

			while( strText.hasMoreTokens())
			{

				try {
					tree.addNode(new Node(new Fraction(strText.nextToken())), tree.root, tree.root);
				} catch (NumberFormatExpressionException e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
			}

			if ( rbAscending.isSelected() )
			{	
				txtSorted.setText(tree.inOrderString(tree.root,""));
			}
			else
			{	
				txtSorted.setText(tree.revOrderString(tree.root,""));
			}				
			
		}
	}

}
