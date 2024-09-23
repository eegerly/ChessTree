@echo off

rem Java class file compiler and archiver for freeplane library
rem =============== Usage =============== 
rem compile.bat FILE.groovy
rem FILE.groovy will be compiled as FILE.class and will be archived to <libName>.jar


set JDKPath=c:\Program Files\Java\jdk-23\
set FPInstallDir=c:\Portables\freeplane
set FPUserDir=C:\Users\ger\AppData\Roaming\Freeplane\1.12.x\lib\
set groovyVersion=4.0.21
set freeplanePluginVersion=1.12.6
set libName=ChessTree
set addonName=chessTree
set file=%1
echo. Compiling %file% ...

set libs=%FPInstallDir%\plugins\org.freeplane.plugin.script\lib\groovy-%groovyVersion%.jar;%FPInstallDir%\plugins\org.freeplane.plugin.script\lib\plugin-%freeplanePluginVersion%.jar;%FPInstallDir%\core\org.freeplane.core\lib\freeplaneviewer.jar

java -cp "%libs%" org.codehaus.groovy.tools.FileSystemCompiler ./%file%

if "%ERRORLEVEL%" EQU "0" (
    rem copy %file:.groovy=*.class% C:\Users\ger\AppData\Roaming\Freeplane\1.3.x\addons\%addonName%\lib\>>nul
    rem "%JDKPath%\jar.exe" cf %libName%.jar %libName%/*.class >>nul
    echo.     [OK]
    echo. Creating java archive ...
    "%JDKPath%\bin\jar.exe" uf %libName%.jar %libName%/*.class >>nul
    if "%ERRORLEVEL%" EQU "0" ( echo.     [OK] ) else ( echo.     [FAILED] )

    echo. Copying files ...
    copy %libName%.jar %FPUserDir%\>>nul
    if "%ERRORLEVEL%" EQU "0" ( echo.     [OK] ) else ( echo.     [FAILED] Copying %libName%.jar to %FPUserDir%)
    copy %libName%.jar ..\zips\lib\>>nul
    if "%ERRORLEVEL%" EQU "0" ( echo.     [OK] ) else ( echo.     [FAILED] Copying %libName%.jar to ..\zips\lib\)

) else (
    echo [FAILED] see errors above.
)