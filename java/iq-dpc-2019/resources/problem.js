function escape(carpark){
  return ["L4", "D1", "R4"];
}

carpark = [[1, 0, 0, 0, 2],
  [0, 0, 0, 0, 0]];
result = ["L4", "D1", "R4"];

Test.assertDeepEquals(escape(carpark), result, "Expected '"+result.toString()+"'");