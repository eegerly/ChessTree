@echo off 

set JDKPath=C:\Program Files\Java\jdk1.8.0_162
set FPInstallDir=C:\01--MyDocuments\99--Portables\freeplane-1.6
set FPUserDir=C:\Users\gergely2.kiss\AppData\Roaming\Freeplane\1.6.x\lib
set libName=ChessTree
set addonName=chessTree
set file=%1
echo. Compiling %file% ...

set libs=%FPInstallDir%\plugins\org.freeplane.plugin.script\lib\groovy-all-2.3.1.jar;%FPInstallDir%\plugins\org.freeplane.plugin.script\lib\plugin-1.5.jar

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