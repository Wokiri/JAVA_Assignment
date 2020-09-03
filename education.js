const mysql = require('mysql')

const database = mysql.createConnection({
    // Connect to this user only after creating it
    host: "localhost",
    user: "Joe",
    password: "123456",

    // Connect to this database only after creating it
    database: "education"
})

// A foreign key relationship involves a parent table that holds the initial column values,
// and a child table with column values that reference the parent column values.
// A foreign key constraint is defined on the child table.

database.connect((err) => {
    if (err) throw err;
    console.log("Connected!")

    const studentValues = [
        [1, 'John Mark', 1],
        [2, 'Jane Wes', 2],
        [3, 'Mike Ross', 1],
        [4, 'Arnold Bruce', 1],
        [5, 'Sarah A.', 1],
        [6, 'Baroness Clarkson', 2],
        [7, 'Joe Wokiri', 1],
        [8, 'Paul Powell', 2],
        [9, 'Jacob Owens', 1],
        [10, 'Eve Joyce', 1],
        [11, 'George Adams', 1],
        [12, 'Sarah Joe', 2],
        [13, 'Velma Clarkson', 2],
        [14, 'Jeff Wahington', 2],
        [15, 'Nonce Stephanie', 2],
        [16, 'Vue Stacy', 2],
        [17, 'Stacy Laura', 2],
        [18, 'Spenser Bill', 1]
    ]

    const courseValues = [
        [1, 'Bsc. Actuarial Science', 1],
        [2, 'MPhil Genomics', 2]

    ]

    const institutionValues = [
        [1, 'University College Dublin'],
        [2, 'University College London']

    ]

    const mysqlCommands = {
        createDB_Education: `CREATE DATABASE education`,

        createTable_Student: `CREATE TABLE student(
            studentid INT(11) AUTO_INCREMENT,
            name VARCHAR(250),
            course VARCHAR(11),
            PRIMARY KEY (studentid)
            );`,

        insertIntoStudentTable: `INSERT INTO student (studentid, name, course) VALUES ?;`,

        createTable_Course: `CREATE TABLE course(
            courseid INT(11) AUTO_INCREMENT,
            name VARCHAR(250),
            institution VARCHAR(11),
            PRIMARY KEY(institution),
            FOREIGN KEY(courseid) REFERENCES student(studentid)
            );`,

        insertIntoCourse: `INSERT INTO course (courseid, name, institution) VALUES ?;`,

        createTable_Institution: `CREATE TABLE institution(
            institutionid INT(11) AUTO_INCREMENT,
            name VARCHAR(250),
            PRIMARY KEY(institutionid),
            FOREIGN KEY (institutionid) REFERENCES course(courseid)
            );`,

        insertIntoInstitution: `INSERT INTO institution (institutionid, name) VALUES ?;`
    }

    database.query(

        // run the following in the stated order one by one. Remember to comment it after use

        // mysqlCommands.createDB_Education,
        // mysqlCommands.createTable_Student,
        // mysqlCommands.insertIntoStudentTable, [studentValues],
        // mysqlCommands.createTable_Course,
        // mysqlCommands.insertIntoCourse, [courseValues],
        // mysqlCommands.createTable_Institution,
        // mysqlCommands.insertIntoInstitution, [institutionValues],




        (error, result) => {
            if (error) throw error
            console.log(`Operation Successful!`)
        })
});