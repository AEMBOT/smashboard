# smashboard
Dashboard Interface for FRC 2017 to allow drivers to easily receive and send data to robot from Driver Station
# Development Requirements
* Knowledge in
  * Java
  * Java Swing
  * [WPILib NetworkTables](http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/networktables/NetworkTable.html)
* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)
# Setup
Once the project is cloned and open in IDEA, complete the following steps to create the build configuration:
1. [Install the NetworkTables library](http://first.wpi.edu/FRC/roborio/maven/release/edu/wpi/first/wpilib/networktables/java/NetworkTables/3.1.6/)
1. Open the Project Structure in IDEA
1. Go to _Libraries_, click _new (+)_, _Java_, and locate where you installed **NetworkTables-3.1.6-desktop.jar**
1. Go to _Modules_, _smashboard_, and under the _Dependencies_ tab, check **NetworkTables-3.1.6-desktop**
1. Setup the Single build: Go to _Artifacts_, click _new (+)_, _JAR_, _From modules with dependencies..._. Set _Module_
to _smashboard_, _Main Class_ to _Smashboard_ (click the 3 dots to select it from a list), and make sure _extract to
target JAR_ is selected. Check _Include in project build_.
    
    Optional: Set _Name_ to _SmashboardJar_ and _Output Directory_ to _\<project path\>out/single/_
1. Setup the Linked build: Go to _Artifacts_, click _new (+)_, _JAR_
