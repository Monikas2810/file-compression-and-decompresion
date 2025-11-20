import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Compressor & Decompressor");
        JButton compressBtn = new JButton("Compress File");
        JButton decompressBtn = new JButton("Decompress File");

        compressBtn.setBounds(50, 100, 200, 30);
        decompressBtn.setBounds(300, 100, 200, 30);

        frame.add(compressBtn);
        frame.add(decompressBtn);

        compressBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File inputFile = fileChooser.getSelectedFile();
                File outputZip = new File(inputFile.getParent(), inputFile.getName() + ".zip");
                try {
                    FileCompressor.compressFile(inputFile, outputZip);
                    JOptionPane.showMessageDialog(null, "File compressed successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        decompressBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File zipFile = fileChooser.getSelectedFile();
                File outputDir = zipFile.getParentFile();
                try {
                    FileDecompressor.decompressFile(zipFile, outputDir);
                    JOptionPane.showMessageDialog(null, "File decompressed successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        frame.setSize(600, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}