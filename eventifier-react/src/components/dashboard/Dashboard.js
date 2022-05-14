import React, { useEffect, useState } from 'react'
import { Alert, Button, Card, Container } from 'react-bootstrap'

const Dashboard = ({ user }) => {
    const [status, setStatus] = useState(false)
    const [events, setEvents] = useState([])
    useEffect(() => {
        const getEvents = async () => {
            const res = await fetch("http://localhost:8080/event")
            setStatus(res.status)
            if (res.ok) {
                const events = await res.json()
                console.log(events)
                setEvents(events)
            }
        }
        getEvents()
    }, [])

    const register = async (id) => {
        const res = await fetch(`http://localhost:8080/event/${id}/register`,
        {
            method: 'PATCH',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(user)
        })
        if (res.ok) {
            const event = await res.json()
            setEvents(events.map((e) => (e.id === event.id ? event : e)));
        }
    }

    const unRegister = async (id) => {
        const res = await fetch(`http://localhost:8080/event/${id}/unregister`,
        {
            method: 'PATCH',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(user)
        })
        if (res.ok) {
            const event = await res.json()
            setEvents(events.map((e) => (e.id === event.id ? event : e)));
        }
    }

  return (
    <Container>
        <h1>Liste des Événements</h1>
            {status >= 400 ? <Alert variant="danger">Impossible de récupérer les événements. </Alert>:""}
            {events.length > 0 ? (events.map((event) => (
                <Card className="row" key={event.id}>
                    <Card.Body>
                        <Card.Title>{event.name}</Card.Title>
                        <Card.Subtitle>{event.organizer.name}</Card.Subtitle>
                        <Card.Text>{event.description}</Card.Text>
                        <Card.Subtitle>Participants: {event.participants.length}</Card.Subtitle>
                        {user.userType === "PARTICIPANT" ? <>
                            {!event.participants.some(p => p.id === user.id) ? <Button variant="primary" onClick={() => register(event.id)}>Inscrire</Button>
                            : <Button variant="danger" onClick={() => unRegister(event.id)}>Désinscrire</Button>}
                        </>:""}
                    </Card.Body>
                </Card>
            ))):<p>Aucun événement trouvé</p>}
    </Container>
  )
}

export default Dashboard