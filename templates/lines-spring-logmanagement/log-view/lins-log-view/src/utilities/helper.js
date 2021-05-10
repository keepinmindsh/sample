export function getComparator(type, column) {
    const key = column.toLowerCase();
  
    if (type === "string") {
      return (a, b) => a[key].localeCompare(b[key]);
    }
    if (type === "number") {
      return (a, b) => a[key] - b[key];
    }
    if (type === "object") {
      return (a, b) => a[key] - b[key];
    }
  }
  
  export function formatDate(value) {
    return new Intl.DateTimeFormat("en-GB", {
      year: "numeric",
      month: "short",
      day: "numeric"
    }).format(value);
  }
  