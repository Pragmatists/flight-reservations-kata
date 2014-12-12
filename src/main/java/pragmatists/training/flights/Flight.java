package pragmatists.training.flights;

public class Flight {

    private int mileage;
    public final String number;
    private String airlineCode;
    public final Airline airline;
    private boolean cancelled;
    public String origin;
    public Long originId;
    private String destination;
    private Long destinationId;

    public Flight(String flightNumber) {
        number = flightNumber;
        setAirlineCode("");
        airline = null;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileageAsKm() throws InvalidRequestException {
        if (cancelled) {
            throw new InvalidRequestException("Cannot get cancelled flight mileage");
        }
        return (int) Math.round(mileage * 1.6131);
    }

    public void cancel() {
        cancelled = true;

    }

    public void setOrigin(String origin) {
        this.origin = origin;

    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public void setDestination(String destination) {
        this.destination = destination;

    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((airline == null) ? 0 : airline.hashCode());
        result = prime * result + ((getAirlineCode() == null) ? 0 : getAirlineCode().hashCode());
        result = prime * result + (cancelled ? 1231 : 1237);
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
        result = prime * result + mileage;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((originId == null) ? 0 : originId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Flight other = (Flight) obj;
        if (airline == null) {
            if (other.airline != null) {
                return false;
            }
        } else if (!airline.equals(other.airline)) {
            return false;
        }
        if (getAirlineCode() == null) {
            if (other.getAirlineCode() != null) {
                return false;
            }
        } else if (!getAirlineCode().equals(other.getAirlineCode())) {
            return false;
        }
        if (cancelled != other.cancelled) {
            return false;
        }
        if (destination == null) {
            if (other.destination != null) {
                return false;
            }
        } else if (!destination.equals(other.destination)) {
            return false;
        }
        if (destinationId == null) {
            if (other.destinationId != null) {
                return false;
            }
        } else if (!destinationId.equals(other.destinationId)) {
            return false;
        }
        if (mileage != other.mileage) {
            return false;
        }
        if (number == null) {
            if (other.number != null) {
                return false;
            }
        } else if (!number.equals(other.number)) {
            return false;
        }
        if (origin == null) {
            if (other.origin != null) {
                return false;
            }
        } else if (!origin.equals(other.origin)) {
            return false;
        }
        if (originId == null) {
            if (other.originId != null) {
                return false;
            }
        } else if (!originId.equals(other.originId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flight [number=" + number + "]";
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

}
