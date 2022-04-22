<h1 align="center">
    🔎 Algorithms Comparator 🔎
</h1>

<h3 align="center">
    A simple algorithms comparator used during classes
</h3>


## 📚 About 📚

During studies, I was asked to compare some algorithms running time. Since I would have to do it repeatedly,
I decided to create a simple solution to help me with that. It's still **very** simple since I didn't have too much
time to improve it, but I'll be adding new features with time and hope to be able to help someone.

*In this repository you'll find:*

- **RandomIntegerGenerator class:** A class with a public method *getRandomArray* where you specify a count, a lower and upper bound and get a list size count of randomized integers between lower and upper bounds.
- **AlgorithmsComparer class:** A class with two public methods: setup, where you setup the used inputs and the algorithms you want to compare, and printResults, to print the running results. (Check #NextSteps for a peek in the future!)
- **ComparableAlgorithm interface:** An interface that every algorithm that you wish to compare should implement.
- **Main class:** A main class where you can set up the algorithms you want.
- **algorithms package:** Some example algorithms used in class.

In that construction I was inspired by some design patterns like builder and command, though I've adapted it to solve my own problems. 

One problem I faced was that after some runs, JVM considered my code hot and compiled it, so it was hard to compare algorithms.
The solution I came up with was a method heatAlgorithm, where I run the algorithms against small inputs several times to guarantee that those pieces
of code are already compiled once I start the real tests.

##🖥️ How to Run 🖥️
### Requirements:
- Java 8+ Preferably (Though it may run in much older versions)

### 🚀 Running it 🚀
- Just open the code and run Main class.
- You can create new algorithms and change Main to include them, just remember to implement ComparableAlgorithm interface.

### 🔮 Next Steps!🔮

- Export results in .csv
- Inform approximated Big-O notations
- Create a GUI to display results as graphs
- Handle more types of algorithms

## 🚧 Contributing 🚧
If you see a potential improvement in coding, structure or best practices, please, let me know. I'm here to learn!
If you want to contribute, don't be shy! Open a pull request and let's create something better together!
---

## Show your support

Give a ⭐️ if this repository helped you!

