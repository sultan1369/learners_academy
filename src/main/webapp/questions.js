//creating an array and passing the numbers, questions, options and answers
var questions = [
    {
        numb: 1,
        question: "What Does HTML Stands For?",
        answer: "Hyper Text Markup Language",
        options: [
            "Hyper Text Preprocesser",
            "Hyper Text Markup Language",
            "Hyper Text Multiple Language",
            "Hyper Tool Markup Language"
        ]
    },
    {
        numb: 2,
        question: "Which property is used to change the color of text in CSS?",
        answer: "color",
        options: [
            "font-color",
            "color",
            "text-color",
            "font-style"
        ]
    },
    {
        numb: 3,
        question: "What keyword is used to declare variables in JavaScript?",
        answer: "var",
        options: [
            "var",
            "let",
            "const",
            "variable"
        ]
    },
    {
        numb: 4,
        question: "What attribute is used to provide alternative text for an image in HTML?",
        answer: "alt",
        options: [
            "img-alt",
            "alt-text",
            "img-text",
            "alt"
        ]
    },
    {
        numb: 5,
        question: "What Does SQL Stands For?",
        answer: "Structured Query Language",
        options: [
            "Stylish Question Language",
            "Stylesheet Query Language",
            "Statement Question Language",
            "Structured Query Language"
        ]
    },
    {
        numb: 6,
        question: "Which property is used to control the space between elements' content and its border in CSS?",
        answer: "padding",
        options: [
            "margin",
            "border-spacing",
            "padding",
            "space-between"
        ]
    },
    {
        numb: 7,
        question: "What method is used to add a new element to the end of an array in JavaScript?",
        answer: "push()",
        options: [
            "append() ",
            "insert()",
            "add()",
            "push()"
        ]
    },
    {
        numb: 8,
        question: "In Java, which keyword is used to declare a constant variable?",
        answer: "final",
        options: [
            "static",
            "constant",
            "final",
            "const"
        ]
    },
    {
        numb: 9,
        question: "What does JSP stand for?",
        answer: "JavaServer Pages",
        options: [
            "Java Server Programming",
            "JavaServer Pages",
            "JavaScript Page",
            "Java Servlet Pages"
        ]
    },
    {
        numb: 10,
        question: "Which of the following is NOT a valid HTTP method for handling requests in JSP?",
        answer: "PUT",
        options: [
            "GET",
            "DELETE",
            "POST",
            "PUT"
        ]
    },
    {
        numb: 11,
        question: "Which type of database model organizes data in a tree-like structure with parent-child relationships?",
        answer: "Hierarchical database",
        options: [
            "NoSQL database",
            "Relational database",
            "Network database",
            "Hierarchical database"
        ]
    },
    {
        numb: 12,
        question: "Which SQL keyword is used to retrieve data from a database?",
        answer: "SELECT",
        options: [
            "FETCH",
            "SELECT",
            "GET",
            "RETRIEVE"
        ]
    },
    {
        numb: 13,
        question: "What does ACID stand for in the context of database transactions?",
        answer: " Atomicity, Consistency, Isolation, Durability",
        options: [
            " Atomicity, Consistency, Isolation, Durability",
            "Aggregation, Compression, Indexing, Distribution",
            "Association, Concurrency, Integrity, Dependencies",
            "Access, Control, Identification, Distribution"
        ]
    },
    {
        numb: 14,
        question: "Which of the following is NOT a type of NoSQL database?",
        answer: "Relational",
        options: [
            "Document-oriented",
            "Relational",
            "Columnar",
            "Graph"
        ]
    },
    {
        numb: 15,
        question: "What is a foreign key in a relational database?",
        answer: "A reference to a primary key in another table",
        options: [
            "A key used for joining tables",
            "A key that uniquely identifies each record in a table",
            "A key used for indexing columns",
            "A reference to a primary key in another table"
        ]
    },
];

var studentQuestions = getRandomQuestions(10);
function getRandomQuestions(count) {
    var randomQuestions = [];
    var shuffledQuestions = questions.sort(() => Math.random() - 0.5);
    for (var i = 0; i < count; i++) {
        randomQuestions.push(shuffledQuestions[i]);
    }
    return randomQuestions;
}

displayQuestion();
