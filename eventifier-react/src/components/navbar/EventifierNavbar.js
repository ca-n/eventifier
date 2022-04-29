import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const EventifierNavbar = ({ user }) => {
  return (
      <Navbar bg="primary" variant="dark">
          <Container>
              <Navbar.Brand>Eventifier</Navbar.Brand>
              <Nav className="me-auto">
                  {user.email.length === 0 ? (
                  <>
                    <Nav.Link as={Link} to="/login">Login</Nav.Link>
                    <Nav.Link as={Link} to="/register">Register</Nav.Link>
                  </>
                  ) : (
                  <>
                    <Nav.Link as={Link} to="/login">Logout</Nav.Link>
                  </>
                  )}
              </Nav>
          </Container>
      </Navbar>
  )
}

export default EventifierNavbar