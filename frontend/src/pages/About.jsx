import React from 'react';

const About = () => {
  return (
    <div className="container py-5">
      <div className="text-center mb-5">
        <h1 className="fw-bold">About Mobile Zone</h1>
        <p className="lead mx-auto" style={{ maxWidth: '800px' }}>
          At <strong>Mobile Zone</strong>, we bring the latest and greatest smartphones directly to your fingertips.
          Our goal is to help you find the perfect device for your lifestyle by providing detailed comparisons and
          the newest releases in one place.
        </p>
      </div>

      <div className="row g-4 justify-content-center">
        <div className="col-lg-5">
          <div className="card h-100 shadow-sm border-0 text-center">
            <div className="card-body ">
              <h4 className="card-title fw-semibold mb-4">Contact Us</h4>
              <ul className="list-unstyled">
                <li className="mb-3"><i className="bi bi-envelope me-2"></i> support@mobilezone.com</li>
                <li className="mb-3"><i className="bi bi-telephone me-2"></i> +359 88 123 4567</li>
                <li className="mb-3"><i className="bi bi-geo-alt me-2"></i> Sofia, Bulgaria</li>
              </ul>
              <div className="d-flex justify-content-center gap-3 mt-4">
                <a href="#" className="text-decoration-none"><i className="bi bi-facebook fs-4 text-primary"></i></a>
                <a href="#" className="text-decoration-none"><i className="bi bi-instagram fs-4 text-danger"></i></a>
                <a href="#" className="text-decoration-none"><i className="bi bi-twitter fs-4 text-info"></i></a>
                <a href="mailto:support@mobilezone.com" className="text-decoration-none"><i className="bi bi-envelope-at fs-4 text-secondary"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div className="col-lg-6">
          <div className="card h-100 shadow-sm border-0">
            <div className="card-body">
              <h4 className="card-title fw-semibold mb-4">Send a Message</h4>
              <form>
                <div className="mb-3">
                  <label htmlFor="name" className="form-label">Your Name</label>
                  <input type="text" className="form-control" id="name" placeholder="Enter your name" />
                </div>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">Email address</label>
                  <input type="email" className="form-control" id="email" placeholder="name@example.com" />
                </div>
                <div className="mb-3">
                  <label htmlFor="message" className="form-label">Your Message</label>
                  <textarea className="form-control" id="message" rows="4" placeholder="Type your message here..."></textarea>
                </div>
                <button type="submit" className="btn btn-primary w-100">Send</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default About;
