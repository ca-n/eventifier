import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const EventifierNavbar = () => {
  return (
      <Navbar bg="primary" variant="dark">
          <Container>
              <Navbar.Brand>Eventifier</Navbar.Brand>
              <Nav className="me-auto">
                  <Nav.Link as={Link} to="/login" className="nav-link">Login</Nav.Link>
                  <Nav.Link as={Link} to="/register" className="nav-link">Register</Nav.Link>
              </Nav>
          </Container>
      </Navbar>
  )
}

export default EventifierNavbar