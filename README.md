# Mobile-Application-Development-for-Institutes

<h2>Description</h2>
  <p>This application allows users who are teachers and students from an Educational Institute to manage their profiles and access relevant information.</p>

  <h2>Objectives</h2>
  <ul>
    <li>Facilitate user login with secure credential checks.</li>
    <li>Provide separate interfaces for teachers and students.</li>
    <li>Enable teachers to:
      <ul>
        <li>Register new teachers.</li>
        <li>Register for library access.</li>
        <li>View categorized subject streams.</li>
        <li>Access institute contact information.</li>
      </ul>
    </li>
    <li>Enable students to:
      <ul>
        <li>Register as students.</li>
        <li>Register for library access.</li>
        <li>View class schedules.</li>
        <li>Access institute contact information.</li>
      </ul>
    </li>
    <li>Utilize SQLite databases to store user information securely on the device.</li>
  </ul>

  <h2>Steps</h2>
  <ol>
    <li><strong>Logging Page:</strong>
      <ul>
        <li>Users can enter their username and password for login.</li>
        <li>The system validates credentials against a predefined set (e.g., "School" and "1234").</li>
        <li>Incorrect credentials display an error message.</li>
      </ul>
    </li>
    <li><strong>Category Selection:</strong>
      <ul>
        <li>Upon successful login, users choose their category (Teacher or Student).</li>
      </ul>
    </li>
    <li><strong>Teacher's Category:</strong>
      <ul>
        <li>Provides options for:
          <ul>
            <li>Teacher Registration:
              <ul>
                <li>A form collects teacher details (name, index number, address, email, contact number).</li>
                <li>Email validation ensures a valid "@gmail.com" format.</li>
                <li>Contact number validation restricts input to 10 digits.</li>
                <li>Successful registration displays a confirmation message and clears the form.</li>
              </ul>
            </li>
            <li>Library Registration:
              <ul>
                <li>Allows teachers to register for library access.</li>
                <li>Captures full name, index number, and selectable date/time options.</li>
                <li>Successful registration displays a confirmation message and clears the form.</li>
              </ul>
            </li>
            <li>Categories of Streams:
              <ul>
                <li>Showcases the main subjects offered (e.g., Mathematics, Science, Art, Commerce, Technology, History).</li>
                <li>Clicking a subject displays a confirmation message (e.g., "Mathematics category is clicked").</li>
              </ul>
            </li>
            <li>Contact Information:
              <ul>
                <li>Provides contact details (email and phone numbers) for key institute personnel (Principal, Vice Principal, Administrator, Counselor).</li>
              </ul>
            </li>
          </ul>
        </li>
      </ul>
    </li>
    <li><strong>Student's Category:</strong>
      <ul>
        <li>Provides options for:
          <ul>
            <li>Student Registration:
              <ul>
                <li>A form collects student details (name, index number, address, contact number, grade).</li>
                <li>Contact number validation restricts input to 10 digits.</li>
                <li>Successful registration displays a confirmation message and clears the form.</li>
              </ul>
            </li>
            <li>Library Registration:
              <ul>
                <li>Allows students to register for library access.</li>
                <li>Captures full name, index number, and selectable date/time options for library visits.</li>
                <li>Successful registration displays a confirmation message and clears the form.</li>
              </ul>
            </li>
            <li>Class Room Schedule:
              <ul>
                <li>Displays a clear chart with classroom numbers assigned to each grade (Grade 1 to Grade 12).</li>
              </ul>
            </li>
            <li>Contact Information:
              <ul>
                <li>Provides contact details (email and phone numbers) for key institute personnel (Principal, Vice Principal, Administrator, Counselor).</li>
              </ul>
            </li>
          </ul>
        </li>
      </ul>
    </li>
    <li><strong>Databases:</strong>
      <ul>
        <li>The app utilizes SQLite databases to store user information securely on the device.</li>
        <li>Separate databases exist for Teachers and Students.</li>
        <li>Each database has two tables:
          <ul>
            <li>Registration table: Stores user details (name, index number, etc.).</li>
            <li>Library Registration table: Stores library access details (date, time).</li>
          </ul>
        </li>
      </ul>
    </li>
  </ol>

  <h2>Technologies Used</h2>
  <ul>
    <li>Android Studio</li>
    <li>SQLite</li>
  </ul>

  <h2>Author</h2>
  <p><strong>Nisansala Amarasinghe</strong></p>
