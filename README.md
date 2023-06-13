# TaskApplication
 Simple Console Application

Welcome to our “Task application”!

Before you start using our app, you need to go through a few easy steps
to prepare the environment which our application needs:

1.  Open this link: <https://www.h2database.com/html/main.html> and
    click on the “Windows Installer” icon which is surrounded by green
    (for Windows and other icon for All Platforms).

<img src="media/image1.png" style="width:6.53193in;height:4.05833in" />

This will start downloading the Installer:

<img src="media/image2.png" style="width:6.53194in;height:3.67431in" />

2.  Once the download is completed, you have to run the Installer:

> <img src="media/image3.png" style="width:6.53194in;height:3.67431in" />

You can easily install it by press “Next” button and then “Install”

3.  After you successfully installed H2 Database Engine you can

Start it by open the H2 Database Engine icon from you applications menu:

<img src="media/image4.png" style="width:6.025in;height:3.38914in" />

4-When you start the H2Console(Command Line) you will be redirected to
the login form of the Database we use, while you see this black window
that means the H2 DB Engine is running and is ready to connect:

<img src="media/image5.png" style="width:6.53194in;height:3.67431in" />

And then you just press “Connect” button without enter neither username
or password.

4.  There you go, that is our database which we use, there you can see
    the TASKS table, where we store our data:

<img src="media/image6.png" style="width:6.53194in;height:3.67431in" />

One very specific thing to work with this H2 DB Engine is that you can’t
run the H2 DB Engine at the same time when you are running the code for
the application in IntelliJ or other compiler. So before you start the
code from the compiler you need to CLOSE the H2 Console.

And then you can start the application from a compiler. And also if you
want to connect to H2 DB Engine while you compiler is running you will
have a problem, because the both things can’t work at the same time!

So REMEMBER:

-   When you want to start the code with a compiler ->You have to Close
    the H2 Console !

-   When you want to connect with H2 DB Engine from the Browser -> You
    have to Stop the compilation running from your compiler and Open the
    H2 Console icon.

> I will show it with examples bellow:

-When you try to start the code with a compiler while H2 Console is
running -> you get this error:

<img src="media/image7.png" style="width:6.53194in;height:3.67431in" />

Solution: close the H2 Console app

<img src="media/image8.png" style="width:6.53194in;height:3.67431in" />

If you try to open the H2 Console while your compiler is running the
code you will get this error and the solution is quite simple -> just
stop your compiler and then open the H2 Console and Connect to the
Database!

<img src="media/image9.png" style="width:6.53194in;height:3.67431in" />

When you stop the compiler running you can enter again in the database!

That’s the look when you connect successfully to the Database

Initially the table will be empty

<img src="media/image10.png" style="width:6.53194in;height:3.67431in" />

Finally you know what are the specific things with our application and
now you can explore it by yourself.

**Short Intro:**

To use our application, you have to choose from the **digits,** which
are showed in the console, in front of every command. This **digit holds
the functionality of the commands** and will avoid you from that, to
write commands by yourself, so you just need to choose any of the digits
in front of the showed commands.

-After each of the commands we have selected, we receive an appropriate
message whether it was executed successfully or not

The commands you can choose from are:

1.  **Add Task** - This command checks if the task we want to add
    already exists in our task list, and if there is no task with the
    same title as the task we want to add to our list, it adds it to the
    list. The digit which represents the functionality of this command
    is “1”.

2.  **Edit Task** – This command checks if the task we want to edit
    exists in our list with active tasks and if such a task exists, edit
    it’s title and description. The digit which represents the
    functionality of this command is “2”.

3.  **Remove Task** – This command checks if the task we want to remove
    exists in our list with tasks and if such a task exists, removes it
    from the list. The digit which represents the functionality of this
    command is “3”.

4.  **Show Active Tasks** – This command shows the tasks that are
    finished from our list. The digit which represents the functionality
    of this command is “4”.

5.  **Show Deleted Tasks** – This command shows the tasks that are
    deleted from our list. The digit which represents the functionality
    of this command is “5”.

6.  **Extract Active Tasks To A File –** This command extracts the all
    active tasks in a file. The digit which represents the functionality
    of this command is “6”.

7.  **Extract Deleted Tasks To A File-** This command extracts all the
    deleted tasks in a file. The digit which represents the
    functionality of this command is “7”.

8.  **Exit –** This command stops the application. The digit which
    represents the functionality of this command is “8”.

**The rest is in your hands, so, Happy Exploring.**
