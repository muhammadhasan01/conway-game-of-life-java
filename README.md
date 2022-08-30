# Conway Game Of Life

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitLab](https://img.shields.io/badge/gitlab-%23181717.svg?style=for-the-badge&logo=gitlab&logoColor=white)

[Conway Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) Implementation in Java.

<div style="text-align: center;">

![conway-illustration](https://upload.wikimedia.org/wikipedia/commons/e/e5/Gospers_glider_gun.gif)

</div>


The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells,
each of which is in one of two possible states, live or dead (or populated and unpopulated,
respectively). Every cell interacts with its eight neighbours, which are the cells that are
horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions
occur:

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## 🛠️ Prerequisite

Here is the prerequisite for this project:

- JDK version 18.0.2

## 🏗️ How to build

You can simply build the project by using this command:

```bash
./gradlew build
```

## 🚀 How to use

You can run the project by using this command:

```bash
./gradlew run --console=plain
```

The program will run, and you will be prompted to input a source file:

```
Input the filename path: ...
```

you can use the examples in [inputs](./inputs), an example would be:

```
Input the filename path: inputs/blinker.txt
```

After that, you can watch the show 😎

**Note:**

- If you want to stop the program, you can use `CTRL + C`.
- In some cases the cells doesn't seem to move, this is because the program will follow the movement
  of the cells.
- The program will continue to prompt until valid input file is received (invalid files examples
  are `inputs/invalid.txt` and `inputs/empty.txt`).

## 🧪 How to test

You can test this project by using this command:

```bash
./gradlew test
```

To open the test coverage, simply `open jacoco/test/html/index.html`.

## ⭐ Acknowledgments

- GoTo Financial Bootcamp 2022 Batch 2 Participants & Coaches
- All the java, gradle, git, and other tutorials that have been used
- [Intellij Java Google Style](https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml)
- [JaCoCo - Java Code Coverage](https://github.com/jacoco/jacoco)
