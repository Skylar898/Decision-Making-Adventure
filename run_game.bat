CLS

:: LOCAL VARIABLES ....................................................


SET SRCDIR=src
SET BINDIR=bin
SET BINOUT=adventure-javac.out
SET BINERR=adventure-javac.err
SET JARNAME=Adventure.jar
SET JAROUT=adventure-jar.out
SET JARERR=adventure-jar.err
SET MAINCLASSSRC=src/adventure/DecisionMakingAdventure.java
SET MAINCLASSBIN=adventure.DecisionMakingAdventure


:: EXECUTION STEPS  ...................................................


javac -Xlint -cp ".;%SRCDIR%;" %MAINCLASSSRC% -d %BINDIR% > %BINOUT% 2> %BINERR%

cd bin
jar cvfe %JARNAME% %MAINCLASSBIN% . > %JAROUT% 2> %JARERR%
start java -jar %JARNAME%
cd ..

:: End of Script ......................................................
