import React, { useEffect, useState } from 'react'
import { Alert, Button, ButtonGroup, Container, Form } from 'react-bootstrap'
import { useNavigate } from 'react-router-dom'

const Login = ({ setUser, setIsLoggedIn }) => {
  const [status, setStatus] = useState(0)
  const [validated, setValidated] = useState(false)
  const [credentials, setCredentials] = useState({
    email: "",
    password: ""
  })
  const navigate = useNavigate();
  const [loginType, setLoginType] = useState("participant")

  const onChangeLoginType = (event) => {
    setLoginType(event.target.value);
}

  useEffect(() => {
    setUser({email: ""})
  }, [setUser]);

  const login = async (e) => {
    e.preventDefault()
    const form = e.currentTarget
    setValidated(true)
    if (form.checkValidity()) {
      const res = await fetch(`http://localhost:8080/${loginType}/login`,
      {
        method: 'POST',
        headers: {
          'Content-type': 'application/json'
        },
        body: JSON.stringify(credentials)
      })
      setStatus(res.status)
      if (res.ok) {
        const user = await res.json()
        setUser(user)
        setIsLoggedIn(true)
        setTimeout(() => navigate("/dashboard"), 1000)
      }
    }
  }

  const onChange = (e) => {
    const { id, value } = e.target
    setCredentials({
      ...credentials,
      [id]: value,
    })
  }

  return (
    <Container>
      {status === 200 ? <Alert variant="success">Connexion Réussie!</Alert>:""}
      {status >= 400 ? <Alert variant="danger">Connexion Échoué. {status}</Alert>:""}
      <h1>Connexion</h1>
        <ButtonGroup size="sm" onClickCapture={onChangeLoginType}>
          <Button variant={loginType === "participant" ? "primary" : "outline-primary"} value="participant">Participant</Button>
          <Button variant={loginType === "organizer" ? "primary" : "outline-primary"} value="organizer">Organizateur</Button>
        </ButtonGroup>
        <Form noValidate validated={validated} onSubmit={login} onChange={onChange}>
            <Form.Group className="mb-3" controlId="email">
                <Form.Label>Courriel</Form.Label>
                <Form.Control type="email" placeholder="mail@example.com"/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="password">
                <Form.Label>Mot de passe</Form.Label>
                <Form.Control type="password"/>
            </Form.Group>
            <Button variant="primary" type="submit">Se Connecter</Button>
        </Form>
    </Container>
  )
}

export default Login