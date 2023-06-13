# TaskApplication
 Simple Console Application

Welcome to our "Task application"!

Before you start using our app, you need to go through a few easy steps to prepare the environment which our application needs:

1. Open this link: [https://www.h2database.com/html/main.html](https://www.h2database.com/html/main.html) and click on the "Windows Installer" icon which is surrounded by green (for Windows and other icon for All Platforms).

![](RackMultipart20230613-1-dzgddz_html_e93dbd16f1855e06.png)

This will start downloading the Installer:

![](RackMultipart20230613-1-dzgddz_html_cd73b6f64e7b7872.png)

1. Once the download is completed, you have to run the Installer:

![](RackMultipart20230613-1-dzgddz_html_165ec8e40281aad6.png)

You can easily install it by press "Next" button and then "Install"

1. After you successfully installed H2 Database Engine you can

Start it by open the H2 Database Engine icon from you applications menu:

![](RackMultipart20230613-1-dzgddz_html_8f5c62a892d0db6c.png)

4-When you start the H2Console(Command Line) you will be redirected to the login form of the Database we use, while you see this black window that means the H2 DB Engine is running and is ready to connect:

![](RackMultipart20230613-1-dzgddz_html_5dc45ceebe268401.png)

And then you just press "Connect" button without enter neither username or password.

1. There you go, that is our database which we use, there you can see the TASKS table, where we store our data:

![](RackMultipart20230613-1-dzgddz_html_cdb1fb1067154bdf.png)

One very specific thing to work with this H2 DB Engine is that you can't run the H2 DB Engine at the same time when you are running the code for the application in IntelliJ or other compiler. So before you start the code from the compiler you need to CLOSE the H2 Console.

And then you can start the application from a compiler. And also if you want to connect to H2 DB Engine while you compiler is running you will have a problem, because the both things can't work at the same time!

So REMEMBER:

- When you want to start the code with a compiler -\>You have to Close the H2 Console !
- When you want to connect with H2 DB Engine from the Browser -\> You have to Stop the compilation running from your compiler and Open the H2 Console icon.

I will show it with examples bellow:

-When you try to start the code with a compiler while H2 Console is running -\> you get this error:

![](RackMultipart20230613-1-dzgddz_html_db0a46984283e3df.png)

Solution: close the H2 Console app

![](RackMultipart20230613-1-dzgddz_html_3116834d99507fc3.png)

If you try to open the H2 Console while your compiler is running the code you will get this error and the solution is quite simple -\> just stop your compiler and then open the H2 Console and Connect to the Database!

![](RackMultipart20230613-1-dzgddz_html_625ac96be215ea4d.png)

When you stop the compiler running you can enter again in the database!

That's the look when you connect successfully to the Database

Initially the table will be empty

![](RackMultipart20230613-1-dzgddz_html_fb9845263333ca90.png)

Finally you know what are the specific things with our application and now you can explore it by yourself.

**Short Intro:**

To use our application, you have to choose from the **digits,** which are showed in the console, in front of every command. This **digit holds the functionality of the commands** and will avoid you from that, to write commands by yourself, so you just need to choose any of the digits in front of the showed commands.

-After each of the commands we have selected, we receive an appropriate message whether it was executed successfully or not

The commands you can choose from are:

1. **Add Task** - This command checks if the task we want to add already exists in our task list, and if there is no task with the same title as the task we want to add to our list, it adds it to the list. The digit which represents the functionality of this command is "1".
2. **Edit Task** – This command checks if the task we want to edit exists in our listwith active tasks and if such a task exists, edit it's title and description. The digit which represents the functionality of this command is "2".
3. **Remove Task** – This command checks if the task we want to remove exists in our list with tasks and if such a task exists, removes it from the list. The digit which represents the functionality of this command is "3".
4. **Show Active Tasks** – This command shows the tasks that are finished from our list. The digit which represents the functionality of this command is "4".
5. **Show Deleted Tasks** – This command shows the tasks that are deleted from our list. The digit which represents the functionality of this command is "5".
6. **Extract Active Tasks To A File –** This command extracts the all active tasks in a file. The digit which represents the functionality of this command is "6".
7. **Extract Deleted Tasks To A File-** This command extracts all the deleted tasks in a file. The digit which represents the functionality of this command is "7".
8. **Exit –** This command stops the application. The digit which represents the functionality of this command is "8".

**The rest is in your hands, so, Happy Exploring.**
