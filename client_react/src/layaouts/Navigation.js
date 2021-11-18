import React from 'react'
import { Nav, Navbar, NavbarBrand, NavDropdown } from 'react-bootstrap'

export default function Navigation() {
    return (
        <Navbar bg="dark" variant="dark" expand="lg">
          <Navbar.Brand>React Java</Navbar.Brand>
          <Navbar.Collapse id="main-menu">
              <Nav className="mr-auto">
                  <Nav.Link>Create Post</Nav.Link>
              </Nav>
              <Nav>
                  <Nav.Link>Crear Cuenta</Nav.Link>
                  <NavDropdown title="Sebastian Rojas" id="menu-dropdown"></NavDropdown>
              </Nav>
          </Navbar.Collapse>
      </Navbar>
       
    )
}
