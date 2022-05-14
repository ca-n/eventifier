import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const EventifierNavbar = ({ user, isLoggedIn }) => {
  return (
      <Navbar bg="primary" variant="dark">
          <Container>
              <Navbar.Brand>Eventifier</Navbar.Brand>
              <Nav className="me-auto">
                {!isLoggedIn ? <Nav.Link as={Link} to="/login">Connexion</Nav.Link>:""}
                {!isLoggedIn ? <Nav.Link as={Link} to="/register">Inscription</Nav.Link>:""}
                {(isLoggedIn && user.userType === "ORGANIZER") ? <Nav.Link as={Link} to="/create">Créer un évènement</Nav.Link>:""}
                {isLoggedIn ? <Nav.Link as={Link} to="/logout">Déconnexion</Nav.Link>:""}
              </Nav>
          </Container>
      </Navbar>
  )
}

export default EventifierNavbar