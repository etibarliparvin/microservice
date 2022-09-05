def age = 1
println("Hello ${age} Groovy");

def myFunction = {println("Hello Groovy")};

myFunction.call();

def clos = {param -> println("Hello ${param}")}

clos.call("World");