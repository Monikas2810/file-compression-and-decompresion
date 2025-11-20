# File Compressor & Decompressor
A simple Java desktop application to compress and decompress files using ZIP format. Built with Swing for the UI and java.util.zip for file operations.

# Features
- Compress any file into .zip format
- Decompress .zip files to original content
- Simple GUI using Java Swing
- Error handling and user notifications


Project Structure
FileCompressor/
-FileCompressor.java    
-FileDecompressor.java     
-MainApp.java              
# How to Run
- Compile all files:
javac *.java
- Run the app:
java MainApp
# How It Works
- Compression: Reads selected file → creates ZIP entry → writes to .zip file
- Decompression: Reads ZIP file → extracts entries → writes original files to output folder
- GUI: Two buttons for compress and decompress, with file chooser dialogs

# Limitations
- Only supports single-file compression (can be extended to folders)
- No progress bar (optional enhancement)

# Learning Outcomes
- File I/O in Java
- ZIP stream handling
- GUI design with Swing
- Exception handling and user feedback

# Deliverables
- Source code files
- Executable .jar (optional)
- Screenshots of working app

