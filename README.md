IN-MEMORY-FILE-SYSTEM Console based Application
-created by Vikram pai V

This is a Console based Application built on Java Programming Language, using the I/O Classes.
This Application is Tested using JUnit Testing Framework and all the dependencies are managed in the form of a Maven Project.
Scanner Class and it's methods have been used to  accept the user's input and to validate based on that.
An infinite loop has been implemented which break's upon the user's selection of "exit" option.
I have created three seperate classes for the ease of development
one is the main class called app, the second is the Utilities class where certain methods of that are repeated are implemented, and finally a functionalty class, in which all the methods relating to the above mentioned functionalitites have been implemented.
This Application might not be exactly similar to the command prompt, but it maybe considered a smaller clone of cmd.
All the Errors and exceptions are handled.
I have Used the File Class to create, remove or change directory, BufferedReader class to read the data within a file, Printwriter class to write into a file.
I have used FileUtils Class to copy or move files/folders from source to destination locations.

These are the basic functionalitites implemented in this Application
mkdir: Create a new directory.
cd: Changes the current directory. Support navigating to the parent directory using .., moving to the root directory using /, and navigating to a specified absolute path. Basically anything that you can do in a normal terminal. Since there is no user level implementation, ~ and / should take you to root.
ls: List the contents of the current directory or a specified directory.
grep: Search for a specified pattern in a file. PS: Its a bonus
cat: Display the contents of a file.
touch: Create a new empty file.
echo: Write text to a file. ex - echo 'I am "Finding" difficult to write this to file' > file.txt
mv: Move a file or directory to another location. ex - mv /data/ice_cream/cassata.txt ./data/boring/ice_cream/mississippimudpie/
cp: Copy a file or directory to another location. ex - cp /data/ice_cream/cassata.txt . **. For current directory **
rm: Remove a file or directory.

Setup Instructions:
1) Download the source code from the link given below:
   https://github.com/vikramartist/In-Memory-File-System.git
2) You can clone this project or use download zip file of the same.
3) Once you have downloaded, extract all the files from the zip folder.
4) Open the main Project folder "In-Memory_File_System" in eclipse.
5) You can right away start the Application by clicking on the run button.
6) Now for the options, here are the insturctions to be followed.
   a)Create a New Directory (mkdir): This command is used to create a new folder/directory in the specified path intially, the path will be to the Project folder, but can be changed using the options. You can use the mkdir option as specified below
      1) mkdir [files...]
      2) mkdir file.txt.
  
         
         Example: [User-dir]\eclipse-workspace\[Project-name]\> mkdir

         This is will create a new folder with default name "New Folder" in the specified path.
         If you want to give a desired name to the folder, then
         
         [User-dir]\eclipse-workspace\[Project-name]\> mkdir file1 file2 file3

         You can pass one or more folder names as shown.

   b) cd (Change Directory) - This command is used to change the path into a given path.

      The options are as given below:
      1) cd path\innerpath\innerpath1
      
      2) cd [folder-name]
         
      3) cd ../ - This command changes the path to it's parent directory.
  
      4) cd ~ or cd / - This command changes the path to it's root folder, in this case C:\Users\[USERNAME]
  
         Example:

         cd tempfile

         cd D:\Temp Folder\Temp Folder

   c) ls - This command gives out the list of contents in the specified path

      1) ls
  
         output:  text.txt
                  folder
                  folder

   d) grep - this command is used to seacrch for a specified pattern in a given file/ files.

      1) grep [option] [pattern] [file/files..]
         
      2) grep -i "uNix" file.txt - Here -i is the option, uNix is the text to be found in the file given.

         There are only a few options which i have implemented. These are some of them:
         1) -c : This prints only a count of the lines that match a pattern
         2) -v : This prints out all the lines that do not matches the pattern
         3) -i : Ignores, case for matching
         4) -n : 	Display the matched lines and their line numbers.
         5) -l : Displays list of a filenames only.

         To Know more about this options. Refer:https://www.geeksforgeeks.org/grep-command-in-unixlinux/

   e) cat - This command displays the content within the file specified.

      1) cat file.txt
  
      2) cat [file.txt, file1.txt,...]

   f) touch - This command is used to create a file.

      1) touch index.html index.css app.js
  
      2) touch index.html
  
         Single or Multiple Files can be created at a time, duplication of files has been handled.

   g) echo - This command is used to write into a given file.

      1) echo * - This gives all the contents of the specified path. It is similar to 'ls' command as shown previously.
  
      2) echo I am "Vikram Pai V" from Bengaluru > file.txt
         I am "Vikram Pai V" from Bengaluru will be written into the file.txt file

   h) mv - This Command is used to move the file or folder from source to destination location.

      1) mv [source] [destination]
      2) mv file.txt file2.txt directory
  
   i) cp - This Command is used to copy the file or folder from source to destionation location.

      1) cp [source] [destination]
      2) cp file.txt file2.txt directory
  
   j) rm - This command is used to remove the files/folders from the given path.

      1) rm file.txt f2.txt
      2) rm [directory] [directory]
         
These are all the functionalities that can be performed in the application.

Version: 1.0.0



