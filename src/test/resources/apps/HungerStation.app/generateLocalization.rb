require 'csv'

arabic_file=File.open('ar.lproj/Localizable.strings',"w")
english_file=File.open('en.lproj/Localizable.strings',"w")

i=0
CSV.foreach('Localization.csv') do |row|
  puts "Writeing Line: #{i}"
  arabic_file.write('"'+row[0]+'"="'+row[1]+'";'+"\n")
  english_file.write('"'+row[0]+'"="'+row[2]+'";'+"\n")
  i+=1
end
