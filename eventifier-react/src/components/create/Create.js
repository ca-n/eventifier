import React, { useState } from 'react'
import { Alert, Button, Container, Form } from 'react-bootstrap'
import { useNavigate } from 'react-router-dom'

const Create = ({ user }) => {
    const navigate = useNavigate()
    const [status, setStatus] = useState(0)
    const [validated, setValidated] = useState(false)
    const [event, setEvent] = useState({
        name: "",
        description: "",
        organizer: user
    })

    const onSubmit = async (e) => {
        e.preventDefault()
        const form = e.currentTarget
        setValidated(true)
        if (form.checkValidity()) {
            const res = await fetch(`http://localhost:8080/event`,
            {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json'
                },
                body: JSON.stringify(event)
            })
            setStatus(res.status)
            if (res.ok) {
                setTimeout(() => navigate("/dashboard"), 2000)
            }
        }
    }

    const onChange = (e) => {
        const { id, value } = e.target
        setEvent({
            ...event,
            [id]: value,
        })
    }

  return (
      <Container>
            {status === 200 ? <Alert variant="success">Événement Créé!</Alert>:""}
            {status >= 400 ? <Alert variant="danger">Impossible de créer l'événement. {status}</Alert>:""}
          <h1>Créer un évènement</h1>
          <Form noValidate validated={validated} onSubmit={onSubmit} onChange={onChange}>
              <Form.Group className="mb-3" controlId="name">
                  <Form.Label>Nom de l'événement</Form.Label>
                  <Form.Control required type="text"/>
              </Form.Group>

              <Form.Group className="mb-3" controlId="description">
                  <Form.Label>Description</Form.Label>
                  <Form.Control as="textarea" rows={3} required placeholder="Détails, lieu, date, heure, etc."/>
              </Form.Group>

              <Button variant="primary" type="submit">Soumis</Button>
          </Form>
      </Container>
  )
}

export default Create