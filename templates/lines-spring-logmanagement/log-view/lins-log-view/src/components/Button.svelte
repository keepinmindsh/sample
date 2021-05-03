<script>
    export let column = "";
    export let sortBy = null;
    export let sortColumn = "";
    export let sortDirection = "";
  
    $: sort = column === sortColumn ? sortDirection : null;
  </script>
  
  <style>
    button {
      font-weight: bold;
      font-size: inherit;
      font-family: inherit;
      text-transform: capitalize;
      background-color: transparent;
      border: none;
      cursor: pointer;
      display: block;
      padding: 0 1rem 0 0;
      background-size: 0.75rem;
      background-repeat: no-repeat;
      background-position: center right;
      background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24'%3E%3Cpath fill='%234f4f4f' d='M16.29 14.29L12 18.59l-4.29-4.3a1 1 0 00-1.42 1.42l5 5a1 1 0 001.42 0l5-5a1 1 0 00-1.42-1.42zM7.71 9.71L12 5.41l4.29 4.3a1 1 0 001.42 0 1 1 0 000-1.42l-5-5a1 1 0 00-1.42 0l-5 5a1 1 0 001.42 1.42z'/%3E%3C/svg%3E");
    }
  
    [data-sort="ASC"],
    [data-sort="DESC"] {
      background-size: 1rem;
      background-position: right -0.15rem center;
    }
  
    [data-sort="ASC"] {
      background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24'%3E%3Cpath fill='%234f4f4f' d='M11.29 11.46a1 1 0 001.42 0l3-3A1 1 0 1014.29 7L12 9.34 9.71 7a1 1 0 10-1.42 1.46zm3 1.08L12 14.84l-2.29-2.3A1 1 0 008.29 14l3 3a1 1 0 001.42 0l3-3a1 1 0 00-1.42-1.42z'/%3E%3C/svg%3E");
    }
  
    [data-sort="DESC"] {
      background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24'%3E%3Cpath fill='%234f4f4f' d='M12.71 12.54a1 1 0 00-1.42 0l-3 3A1 1 0 009.71 17L12 14.66 14.29 17a1 1 0 001.42 0 1 1 0 000-1.42zm-3-1.08L12 9.16l2.29 2.3a1 1 0 001.42 0 1 1 0 000-1.42l-3-3a1 1 0 00-1.42 0l-3 3a1 1 0 001.42 1.42z'/%3E%3C/svg%3E");
    }
  </style>

  <button on:click={() => sortBy(column)} data-sort={sort}>
    {column}
  </button>
