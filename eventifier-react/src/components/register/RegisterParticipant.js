import React, { useState } from 'react'
import { Button, Container, Form } from 'react-bootstrap'

const RegisterParticipant = ({ registerParticipant }) => {
  const [participant, setParticipant] = useState({
    email: "",
    password: "",
    firstName: "",
    lastName: ""
  })

  const register = async (e) => {
    e.preventDefault()
    registerParticipant(participant)
  }

  const onChange = (e) => {
    const { id, value } = e.target
    if (id === "passwordConfirm") return
    setParticipant({
      ...participant,
      [id]: value,
    })
  }

  return (
    <Container>
      <Form onSubmit={register} onChange={onChange}>
        <Form.Group className="mb-3" controlId="email">
          <Form.Label>Email</Form.Label>
          <Form.Control type="email" placeholder="mail@example.com"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="firstName">
          <Form.Label>First Name</Form.Label>
          <Form.Control type="text"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="lastName">
          <Form.Label>Last Name</Form.Label>
          <Form.Control type="text"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="password">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="passwordConfirm">
          <Form.Label>Confirm Password</Form.Label>
          <Form.Control type="password"/>
        </Form.Group>

        <Button variant="primary" type="submit">Register</Button>
      </Form>
    </Container>
  )
}

export default RegisterParticipant