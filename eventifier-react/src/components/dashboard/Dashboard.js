import React from 'react'
import { Card, CardGroup, Container } from 'react-bootstrap'

const Dashboard = () => {
  return (
    <Container>
        <h1>List of Events</h1>
            <Card className="row">
                <Card.Body>
                    <Card.Title>Huge super fun Event!</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">FantasticEvent Co.</Card.Subtitle>
                    <Card.Text>
                        Get ready for the biggest event of the century! Right here in downtown Montreal!
                    </Card.Text>
                    <Card.Link href="#">View Event</Card.Link>
                </Card.Body>
            </Card>

            <Card className="row">
                <Card.Body>
                    <Card.Title>Even Bigger Event!!!!</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">SuperEvent</Card.Subtitle>
                    <Card.Text>
                        Ridiculously big event wow! Get ready, Toronto!
                    </Card.Text>
                    <Card.Link href="#">View Event</Card.Link>
                </Card.Body>
            </Card>

            <Card className="row">
                <Card.Body>
                    <Card.Title>Pool party chez Jérémie</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">Jérémie M.</Card.Subtitle>
                    <Card.Text>
                        Woo party!!
                    </Card.Text>
                    <Card.Link href="#">View Event</Card.Link>
                </Card.Body>
            </Card>
    </Container>
  )
}

export default Dashboard