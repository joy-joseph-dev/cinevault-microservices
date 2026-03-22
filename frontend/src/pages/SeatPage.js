import { useEffect, useState } from "react";

function SeatPage(showId) {

  const [seats, setSeats] = useState([]);
  const [selectedSeats, setSelectedSeats] = useState([]);

  useEffect(() => {
    fetchSeats();
  }, []);

  async function fetchSeats() {
    try {
      const response = await fetch("http://localhost:8080/show-service/seats");
      const data = await response.json();
      setSeats(data);
      console.log(data);
    } catch (error) {
      console.log(error);
    }
  }

  function handleSeatClick(seat) {
    if (seat.booked) return;

    if (selectedSeats.includes(seat.id)) {
      setSelectedSeats(selectedSeats.filter(id => id !== seat.id));
    } else {
      setSelectedSeats([...selectedSeats, seat.id]); 
    }
  }
  async function handleBooking() {
    if(selectedSeats.length===0){
        alert("atleast select one seat to proceed");
        return;
    }
  try {
    const response = await fetch("http://localhost:8080/booking-service/bookings",{
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        showId: showId,
        seatIds: selectedSeats
      })
    });

    const data = await response.json();

    alert("Booking Successful!");
    console.log(data);

  } catch (error) {
    console.log(error);
  }
}

  return (
    <div>
      <h2 className="seatTitle" >Seats</h2>
      <span className="seat-container">
      {seats.map(seat => (
       <div key={seat.id}>
         <button className="seat-button"><p
            onClick={() => !seat.booked && handleSeatClick(seat) }
            style={{
            cursor: seat.booked ? "not-allowed" : "pointer",
            opacity: seat.booked ? 0.5 : 1
  }}
>
           {seat.seatNumber} <br />
            {seat.seatType} <br />
            ${seat.price} <br />
            {seat.booked ? "Booked" : "Available"}
          </p></button> 
       </div>
      ))}
</span>
      <h3>Selected Seats: {selectedSeats.join(", ")}</h3>
      <button className="booking-button" onClick={handleBooking}>Book</button>
    </div>
  );
}
export default SeatPage;