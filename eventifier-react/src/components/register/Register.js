import React, { useState } from 'react'
import { Alert, Button, ButtonGroup, Container } from 'react-bootstrap'
import { useNavigate } from 'react-router-dom';
import RegisterOrganizer from './RegisterOrganizer';
import RegisterParticipant from './RegisterParticipant';

const Register = () => {
    const [registerType, setRegisterType] = useState("participant");
    const [status, setStatus] = useState(0);
    const navigate = useNavigate()


    const onChangeRegisterType = (event) => {
        setRegisterType(event.target.value);
    }

    const register = async (user) => {
      const res = await fetch(`http://localhost:8080/${registerType}`,
      {
        method: 'POST',
        headers: {
          'Content-type': 'application/json'
        },
        body: JSON.stringify(user)
      })
      setStatus(res.status)
      if (res.ok) {
        setTimeout(() => navigate("/login"), 1000)
      }
    }

  return (
    <Container>
        {status === 200 ? <Alert variant="success">Inscription Réussi!</Alert>:""}
        {status >= 400 ? <Alert variant="danger">Inscription Échoué. {status}</Alert>:""}
        <h1>Inscription</h1>
        <ButtonGroup size="sm" onClickCapture={onChangeRegisterType}>
          <Button variant={registerType === "participant" ? "primary" : "outline-primary"} value="participant">Participant</Button>
          <Button variant={registerType === "organizer" ? "primary" : "outline-primary"} value="organizer">Organizateur</Button>
        </ButtonGroup>
        {registerType === "participant" ? (<RegisterParticipant registerParticipant={register}/>):""}
        {registerType === "organizer" ? (<RegisterOrganizer registerOrganizer={register}/>):""}
    </Container>
  )
}

export default Register