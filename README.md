# Arknoid

# Overview
In this project we create the Arkanoid game base on GUI interface of the Bar-Ilan university. <br>
This is assignment in the oop-course of Bar-Ilan University. <br>

# User Guide
The goal is to eliminate all the blocks on the screen. <br>
Every time ball hit block, the block disappeared. <br>
The control in the balls achieved by moving the paddle in the bootom of the screen by the keyboards left and right arrows. <br>
To pause the game use `p`. To continue, use `SPACE`. <br>

# levels
There are 4 levels in this game: <br>
Level 1: <br>
![level 1](https://user-images.githubusercontent.com/118112616/234208966-ec0da81e-89cc-412b-9b3b-b07d84719277.png) <br>

Level 2: <br>
![level 2](https://user-images.githubusercontent.com/118112616/234210279-d1cf539f-652d-49e6-9459-abbf8a01a46e.png) <br>
Level 3: <br>
![level 3](https://user-images.githubusercontent.com/118112616/234210833-20dd8240-5adc-423f-87af-1a61747ef55a.png) <br>
Level 4: <br>
![level 4](https://user-images.githubusercontent.com/118112616/234211778-272fdba6-b2ba-469e-bf36-fac4322c6700.png) <br>

# run <br>
First, clone the repo. Than use the following commands inside the project folder: <br>
To run this game from level 1 to 4 use the command `ant run`. <br>
To run in any other levels order use the command `ant run -Dargs="levels order"`. <br> For example, to start the game in level 2 and after win it move to level 4 write `ant run -Dargs="2 4"`. <br>
To clean all the compilation files use `ant clean`. <br>
To compile the game without run it use `ant compile`. <br>

# Requirements
- Java
- Ant
