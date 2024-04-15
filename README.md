- [Description](#Salesman)
- [Status](#status)
- [Prerequisites](#prerequisites)
- [Running/Compiling](#running-a-package)
- [Linux/Mac](#command-to-runubuntulinux)
- [Settings](#change-settings)
- [Performance](#performance)


# Status
Broken, I tried the GUI and the project had the wrong filestructure that wasn't meant for scaling. The GUI displays one graph that doesn't work but the CLI features are working perfectly, making 4/5 modes work while the last one to visualise the data is not working.
# Salesman
An advanced java program that allows you to remove,add, view and see the various data analytics of some salesmen.
# Prerequisites
Java JDK/SDK
- Computer CPU >400mhz
- RAM >1000MB
# Running A Package
In the package you should see a zip file. After decompression, you can run the command java Main directly in the directory to run the compiled instance of the program.
**This Program is not to be compiled, doing so will cause errors. You must go to the packages section or download it from source to do so.**
# Command to Run(Ubuntu/Linux)
```
Java Main
```
## Change Settings
Find the Debug variable in Main.java and change it
# Performance
Single-Core Performance on an intel core i5-3770 (explicitly handled threads are not used in this program for better performance)
| Number Of People  | Time Taken(ms) |
| ------------- | ------------- |
| 1  | 0.00010007  |
| 100  | 0.000142  |
| 1000  | 0.0092   |
| 10000  | 0.012   |
| 100000  | 0.238  |
| 1000000  | 1.57  |
