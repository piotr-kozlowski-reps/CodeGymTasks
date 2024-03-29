package com.codegym.task.task39.task3907.workers;

public interface Worker {
    void work();
}

//ISP
//The Worker interface contains too many methods that do too many different things. As a result,
// classes that want to support only part of the functionality have to implement methods that they don't actually need.
//It would be much more convenient to have several interfaces that define separate functionality.
//
//Create Sleeper and Eater interfaces in the workers package. Think about how to correctly refactor the code and make the necessary changes.
//
//
//Requirements:
//1. Only the sleep method should be declared in the Sleeper interface.
//2. Only the eat method should be declared in the Eater interface.
//3. Only the work method should remain in the Worker interface.
//4. The NormalWorker class must support the Worker, Sleeper, and Eater interfaces.
//5. The LazyPerson class should only support the Sleeper and Eater interfaces.
//6. The RobotWorker class should only support the Worker interface.
