package com.mvp.ksp

/**
 * annotation for Composable function auto registering to navigation router
 *
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    // function declarations
    // @Composable fun Foo() { ... }
    // lambda expressions
    // val foo = @Composable { ... }
    AnnotationTarget.FUNCTION,

    // type declarations
    // var foo: @Composable () -> Unit = { ... }
    // parameter types
    // foo: @Composable () -> Unit
    AnnotationTarget.TYPE,

    // composable types inside of type signatures
    // foo: (@Composable () -> Unit) -> Unit
    AnnotationTarget.TYPE_PARAMETER,

    // composable property getters and setters
    // val foo: Int @Composable get() { ... }
    // var bar: Int
    //   @Composable get() { ... }
    AnnotationTarget.PROPERTY_GETTER
)
annotation class Screen
