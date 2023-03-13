@echo off

rem Delete all .class files in the current directory
del *.class

rem Compile all .java files in the current directory
javac *.java

rem Check if compilation was successful
if %errorlevel% equ 0 (
    rem If compilation was successful, run the program
    java FortEngine
) else (
    rem If compilation failed, print an error message
    echo Compilation failed!
)

rem Pause to allow the user to read the output
pause