Upgrade to Java 21 (LTS) and verify

This repository contains a small Java file `Light.java`.

Goal: Upgrade the runtime to Java 21 (LTS) and verify compilation and run.

Because the automated JDK install tool isn't available in this environment, follow these manual steps on Windows (PowerShell) to install JDK 21, set JAVA_HOME, and test the project.

1) Download and install a JDK 21 distribution
- Option A: Eclipse Temurin (Adoptium)
  - Visit: https://adoptium.net/
  - Select Java 21 (LTS) and Windows x64 MSI or ZIP and install/unzip.
- Option B: Microsoft Build of OpenJDK
  - Visit: https://learn.microsoft.com/en-us/java/openjdk/download

2) Set JAVA_HOME and update PATH (PowerShell, run as Administrator if required)

# Replace C:\Path\To\jdk-21 with the actual install path
$env:JAVA_HOME = 'C:\Path\To\jdk-21'
[Environment]::SetEnvironmentVariable('JAVA_HOME', $env:JAVA_HOME, 'Machine')
$oldPath = [Environment]::GetEnvironmentVariable('Path', 'Machine')
if ($oldPath -notlike "*%JAVA_HOME%*") {
    [Environment]::SetEnvironmentVariable('Path', $oldPath + ";" + "$env:JAVA_HOME\\bin", 'Machine')
}

# Restart PowerShell to pick up changes: close and re-open the shell

3) Verify Java installation
java -version
javac -version

4) Compile and run the example
cd 'C:\Users\kdaha\OneDrive\Desktop\CORE JAVA'
javac Light.java
java Light

Notes
- If you installed a ZIP distribution, point JAVA_HOME to the extracted folder that contains bin\java.exe.
- If your PATH already includes another Java version, you can use the absolute path to the new java and javac binaries instead, e.g.:
"C:\Path\To\jdk-21\bin\javac" Light.java
"C:\Path\To\jdk-21\bin\java" Light

If you want, I can generate automated PowerShell commands to download and install Temurin JDK 21 (MSI/ZIP) for you; say "do the automated install" and I'll provide the script (you'll need to run it with admin privileges).