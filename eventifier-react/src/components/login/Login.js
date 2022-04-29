import React, { useState } from 'react'
import { Alert, Button, Container, Form } from 'react-bootstrap'
import { useNavigate } from 'react-router-dom'

const Login = ({ setUser }) => {
  const [credentials, setCredentials] = useState({
    email: "",
    password: ""
  })
  const [success, setSuccess] = useState(false)
  const navigate = useNavigate();

  const login = async (e) => {
    e.preventDefault()

    const res = await fetch("http://localhost:8080/participant/login",
    {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: JSON.stringify(credentials)
    })
    const data = await res.json()
    setUser(data)
    if (data) setSuccess(true)
    navigate("/dashboard")
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
        <h1>Login</h1>
        {success ? <Alert variant="success">Logged in Successfully!</Alert> : ""}
        <Form onSubmit={login} onChange={onChange}>
            <Form.Group className="mb-3" controlId="email">
                <Form.Label>Email</Form.Label>
                <Form.Control type="email" placeholder="mail@example.com"/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="password">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password"/>
            </Form.Group>
            <Button variant="primary" type="submit">Login</Button>
        </Form>
    </Container>
  )
}

export default Login