import React, { useState } from 'react'
import { Alert, Container } from 'react-bootstrap'
import RegisterOrganizer from './RegisterOrganizer';
import RegisterParticipant from './RegisterParticipant';

const Register = () => {
    const [registerType, setRegisterType] = useState("participant");
    const [success, setSuccess] = useState(false);

    const onChangeRegisterType = (event) => {
        setRegisterType(event.target.value);
    }

    const registerParticipant = async (participant) => {
      const res = await fetch("http://localhost:8080/participant",
      {
        method: 'POST',
        headers: {
          'Content-type': 'application/json'
        },
        body: JSON.stringify(participant)
      })
      const data = await res.json()
      setSuccess(true)
    }

    const registerOrganizer = (organizer) => {

    }

  return (
    <Container>
        <h1>Register</h1>
        {success ? <Alert variant="success">Registered Successfully!</Alert> : ""}
        <div className="btn-group" role="group" onChange={onChangeRegisterType}>
            <input type="radio" className="btn-check" value="participant" name="regtype" id="reg-par" defaultChecked/>
            <label className="btn btn-outline-primary" htmlFor="reg-par">Participant</label>

            <input type="radio" className="btn-check" value="organizer" name="regtype" id="reg-org"/>
            <label className="btn btn-outline-primary" htmlFor="reg-org">Organizer</label>
        </div>
        {registerType === "participant" ? 
        (<RegisterParticipant registerParticipant={registerParticipant}/>):
        (<RegisterOrganizer registerOrganizer={registerOrganizer}/>)}
    </Container>
  )
}

export default Register