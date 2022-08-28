

class API{
    
    registerStudent(student){
        return fetch('http://localhost:backendport/backend_student_url', {
            method: "POST",
            body: JSON.stringify(student),
            headers: {
                'content-type': 'application/json'
            }
        })
    }
    

}

export default new API();