import React, { useState } from 'react'
import { Button, Container, Form } from 'react-bootstrap'

const RegisterOrganizer = ({ registerOrganizer }) => {
  const [validated, setValidated] = useState(false)
  const [organizer, setOrganizer] = useState({
    email: "",
    password: "",
    name: ""
  })

  const register = async (e) => {
    e.preventDefault()
    const form = e.currentTarget
    setValidated(true)
    if (form.checkValidity()) {
      registerOrganizer(organizer)
    }
  }

  const onChange = (e) => {
    const { id, value } = e.target
    setOrganizer({
      ...organizer,
      [id]: value,
    })
  }

  return (
    <Container>
      <Form noValidate validated={validated} onSubmit={register} onChange={onChange}>
        <Form.Group className="mb-3" controlId="email">
          <Form.Label>Courriel</Form.Label>
          <Form.Control required type="email"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="name">
          <Form.Label>Nom de l'organization</Form.Label>
          <Form.Control required type="text"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="password">
          <Form.Label>Mot de Passe</Form.Label>
          <Form.Control required type="password"/>
        </Form.Group>

        <Button variant="primary" type="submit">S'inscrire</Button>
      </Form>
    </Container>
  )
}

export default RegisterOrganizer