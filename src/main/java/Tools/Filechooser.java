package Tools;

// Java program to use JFileChooser to restrict
// the type of files shown to the user
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
class FileChooser extends JFrame implements ActionListener {
    // Jlabel to show the files user selects
    static JLabel jLabel;
    static JLabel waterAnalysisL;

    // a default constructor
    FileChooser()
    {
    }

    public static void main(String args[])
    {
        // frame to contains GUI elements
        JFrame jFrame = new JFrame("file chooser");
        //jFrame.setLayout();
        // set the size of the frame
        jFrame.setSize(400, 400);

        // set the frame's visibility
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open open dialog
        JButton openButton = new JButton("open");
        JButton waterAnalysisButton = new JButton("water analysis file");

        // make an object of the class filechooser
        FileChooser tissueAnalysisFC = new FileChooser();
        FileChooser waterAnalysisFC = new FileChooser();

        // add action listener to the button to capture user
        // response on buttons
        openButton.addActionListener(tissueAnalysisFC);
        waterAnalysisButton.addActionListener(waterAnalysisFC);


        // set the label to its initial value
        jLabel = new JLabel("no file selected");
        waterAnalysisL = new JLabel("no file selected");


        // make a panel to add the buttons and labels
        JPanel jPanel = new JPanel();

        // add tissue analysis button and label
        jPanel.add(openButton);
        jPanel.add(jLabel);

        // add water analysis button and label
        jPanel.add(waterAnalysisButton);
        jPanel.add(waterAnalysisL);


        // add panel to the frame
        jFrame.add(jPanel);

        jFrame.show();
    }
    public void actionPerformed(ActionEvent evt)
    {
        // create an object of JFileChooser class
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // resctrict the user to selec files of all types
        jFileChooser.setAcceptAllFileFilterUsed(false);

        // set a title for the dialog
        jFileChooser.setDialogTitle("Select tissue analysis file with .xls or .xlsx extension");

        // only allow files of .xls or .xlsx extension
        FileNameExtensionFilter restrict1 = new FileNameExtensionFilter(".xlsx", "xlsx");
        FileNameExtensionFilter restrict2 = new FileNameExtensionFilter(".xls", "xls");
        jFileChooser.addChoosableFileFilter(restrict1);
        jFileChooser.addChoosableFileFilter(restrict2);
        // invoke the showsOpenDialog function to show the save dialog
        int choosen = jFileChooser.showOpenDialog(null);

        // if the user selects a file
        if (choosen == JFileChooser.APPROVE_OPTION) {
            // set the label to the path of the selected file
            jLabel.setText(jFileChooser.getSelectedFile().getAbsolutePath());
        }
        // if the user cancelled the operation
        else
            jLabel.setText("Select tissue analysis file with .xls or .xlsx extension");
    }
}