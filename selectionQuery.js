const mysql = require('mysql')

const database = mysql.createConnection({
    // Connect to this user only after creating it
    host: "localhost",
    user: "Joe",
    password: "123456",

    // Connect to this database only after creating it
    database: "education"
})


database.connect((err) => {
    if (err) throw err
    console.log("Successful DB Access")

    const selectionCommand = `SELECT institution.name as 'INSTITUTION NAME', course.name as 'COURSE NAME',
    COUNT(student.course) AS 'NUMBER OF STUDENTS'
    FROM institution
        LEFT JOIN course 
            ON course.institution = institution.institutionid
        LEFT JOIN student 
            ON student.course = course.courseid
    WHERE course.courseid = student.course
    GROUP BY course.courseid`

    database.query(
        selectionCommand,
        (err, res) => {
            if (err) throw err
            console.log("Operation Successful")
        })
})