package com.learning.roots.kotlinbasics.ui

/**
 * scope functions are a set of functions available in Kotlin that allows concise and convenient operations
 * on objects within a specific scope,that make your code more concise and readable
 */

/**
Function	Object Reference	Return Value	Is Extension
let	            it	            Lambda result	    Yes
run	            this	        Lambda result	    Yes
with	        this	        Lambda result	    No
apply	        this	        Context object	    Yes
also	        it	            Context object	    Yes
 */

/**
 * Scope functions in Kotlin are
 * let
 * with
 * also
 * apply
 * run
 * Lets have some implementations of these functions
 */
fun main() {
    letScopeFunctionDemo()
    withScopeFunctionDemo()
    applyScopeFunctionDemo()
    runScopeFunctionDemo()
    alsoScopeFunctionDemo()
}

/**--------------------------------------------------------------------------------------------------------------------
 * This let function often used to provide null safe calls
 * */
fun letScopeFunctionDemo() {
    var message: String? = null
    /**
     * it will not print anything as it will check if name
     * is null or not before executing the lambda expression
     */
    message?.let { print(it) }
    message = "Believe in yourself,you are awesome!"

    /**
     * now print statement of lambda block will be executed
     * as now message have value means it's not null anymore
     */
    message?.let { println("letScopeFunction: $it") }
}


/**-------------------------------------------------------------------------------------------------------------------------
 * This with function allow to operate on object without calling it's member with dot notation
 */
fun withScopeFunctionDemo() {
    val fruit = Fruit()
    fruit.name = "Orange"
    fruit.color = "Orange"
    fruit.taste = "Sweet-sour"

    with(fruit) {
        println("withScopeFunction: I am a fruit my name is $name, My color is $color, I taste $taste")
    }
}

/**--------------------------------------------------------------------------------------------------------------------------
 * This function is useful to initialize (apply changes to object,as name suggests) the object members
 */
fun applyScopeFunctionDemo() {
    val fruit = Fruit().apply {
        name = "Apple"
        color = "Red"
        taste = "Sweet"
    }

    with(fruit) {
        println("applyScopeFunction: I am again a fruit my name is $name, My color is $color, I taste $taste")
    }
}

/**---------------------------------------------------------------------------------------------------------------------------
 * We can use this function for null safety and to perform some operations on object member as well
 */
fun runScopeFunctionDemo() {
    var fruit: Fruit? = null
    /** This lambda expression will get executed if fruit is not null and we can access name(member of fruit object) directly in lambda block
     * So it is behaving like let and with scope functions at same time
     */
    fruit?.run {
        print(name)
    }
    fruit = Fruit().apply {
        name = "Mango"
        color = "yellow"
        taste = "sweet"
    }

    fruit.run {
        println("runScopeFunction: Hey you are right i am again a fruit my name is $name, My color is $color, I taste $taste")
    }
}

/**---------------------------------------------------------------------------------------------------------------------------
 * We use this function when we have to perform some additional task on object when we have already initialized object members
 */
fun alsoScopeFunctionDemo() {
    val fruitList = arrayListOf("orange", "apple", "mango")
    fruitList.also {
        it.add("banana")
        it.add("guava")
    }
    print("alsoScopeFunction: List of fruits - ")
    fruitList.forEach {
        print("$it ")
    }
}