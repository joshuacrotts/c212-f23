package edu.ast;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpTest {

    @Test
    void interpret() {
        assertAll(
                // 42
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new NumberNode("42").eval(new Environment())),
                // (let ([x 42]) x)
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new LetNode("x", new NumberNode("42"), new VarNode("x")).eval(new Environment())),
                // (+ 1 41)
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new PrimNode("+", new NumberNode("1"), new NumberNode("41")).eval(new Environment())),
                // (let ([x 1]) (let ([y 41]) (+ x y))
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new LetNode("x",
                                new NumberNode("1"),
                                new LetNode("y",
                                        new NumberNode("41"),
                                        new PrimNode("+", new VarNode("x"),
                                                new VarNode("y")))).eval(new Environment())),
                // (program (define x 42) x)
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new ProgramNode(new DefNode("x", new NumberNode("42")),
                                new VarNode("x")).eval(new Environment())),
                // (program (define x 1) (define y 41) (+ x y))
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new ProgramNode(new DefNode("x", new NumberNode("1")),
                                new DefNode("y", new NumberNode("41")),
                                new PrimNode("+", new VarNode("x"),
                                        new VarNode("y"))).eval(new Environment())),
                // (program (define add1 (func (n) (+ n 1))))
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new ProgramNode(new DefNode("add1",
                                new FuncNode(List.of("n"),
                                        new PrimNode("+",
                                                new VarNode("n"),
                                                new NumberNode("1")))),
                                new ApplyNode(new VarNode("add1"),
                                        new NumberNode("41"))).eval(new Environment())),
                // (program (define sub1 (func (n) (- n 1))))
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new ProgramNode(new DefNode("sub1",
                                new FuncNode(List.of("n"),
                                        new PrimNode("-",
                                                new VarNode("n"),
                                                new NumberNode("1")))),
                                new ApplyNode(new VarNode("sub1"),
                                        new NumberNode("43"))).eval(new Environment())),
                // (program (let ([x #t]) (if x 42 0)))
                () -> assertEquals(new Lvalue(new NumberNode("42")),
                        new ProgramNode(new LetNode("x",
                                new BoolNode(true),
                                new IfNode(new VarNode("x"),
                                        new NumberNode("42"),
                                        new NumberNode("0")))).eval(new Environment())),
                // (program (define ! (func (n) (if (eq? n 0) 1 (* n (! (- n 1)))))) (! 5))
                () -> assertEquals(new Lvalue(new NumberNode("120")),
                        new ProgramNode(
                                new DefNode("!",
                                        new FuncNode(List.of("n"),
                                                new IfNode(new PrimNode("eq?", new VarNode("n"), new NumberNode("0")),
                                                        new NumberNode("1"),
                                                        new PrimNode("*", new VarNode("n"),
                                                                new ApplyNode(new VarNode("!"),
                                                                        (new PrimNode("-",
                                                                                new VarNode("n"),
                                                                                new NumberNode("1")))))))),
                                new ApplyNode(new VarNode("!"),
                                        new NumberNode("5"))).eval(new Environment())),
                // (let ([! (lambda (f) (lambda (n) (if (eq? n 0) 1 (* n ((! !) (- n 1))
                () -> assertEquals(new Lvalue(new NumberNode("120")),
                        new LetNode("!",
                                new FuncNode(List.of("f"),
                                        new FuncNode(List.of("n"),
                                                new IfNode(new PrimNode("eq?", new VarNode("n"), new NumberNode("0")),
                                                        new NumberNode("1"),
                                                        new PrimNode("*", new VarNode("n"),
                                                                new ApplyNode(new ApplyNode(new VarNode("!"),
                                                                         new VarNode("!")),
                                                                         new PrimNode("-",
                                                                                new VarNode("n"),
                                                                                new NumberNode("1"))))))),
                                new ApplyNode(new ApplyNode(new VarNode("!"), new VarNode("!")), new NumberNode("5"))).eval(new Environment()))

        );
    }
}