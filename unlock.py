import PyPDF2

def unlock_pdf(input_pdf_path, output_pdf_path, password):
    # Open the encrypted PDF file
    with open(input_pdf_path, 'rb') as file:
        reader = PyPDF2.PdfReader(file)
        
        # Check if the PDF is encrypted
        if reader.is_encrypted:
            # Try to decrypt the PDF with the provided password
            try:
                if not reader.decrypt(password):
                    print("Failed to decrypt PDF: Incorrect password.")
                    return
                print("PDF decrypted successfully.")
            except Exception as e:
                print("Failed to decrypt PDF:", e)
                return
        
        # Create a PDF writer object
        writer = PyPDF2.PdfWriter()
        
        # Add all pages to the writer
        for page in reader.pages:
            writer.add_page(page)
        
        # Write the decrypted content to a new PDF file
        with open(output_pdf_path, 'wb') as output_file:
            writer.write(output_file)
        
        print(f"Decrypted PDF saved as: {output_pdf_path}")

# Usage example
input_pdf = "./Statement 6 months 8729.pdf"
output_pdf = "./decrypted_statement.pdf" 
password = "8729"

unlock_pdf(input_pdf, output_pdf, password)